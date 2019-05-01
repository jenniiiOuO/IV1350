package controller;

import java.util.ArrayList;
import java.util.List;

import integration.ExternBokf�ringssystem;
import integration.F�rs�ljningsregister;
import integration.Kassask�p;
import integration.Kvittoskrivare;
import integration.Lagerkatalog;
import integration.Registerskapare;
import integration.VarorDTO;
import model.K�pinformation;
import model.RegistreradeVarorDTO;
import model.Kalkylator;
import model.Kvitto;

/**
 * Controller f�r programmet, all upprop av metoden fr�n model g�rs h�r
 */
public class Controller 
{
	private Lagerkatalog lagerkatalog;
	private static List<RegistreradeVarorDTO> listaAvRegistreradeVaror = new ArrayList<>();
	private static K�pinformation uppdateradK�pinformation;
	
	/**
	 * Skapar en instans
	 */
	public Controller(Registerskapare registerskapare)
	{
		this.lagerkatalog = registerskapare.getLagerkatalog();
	}
	
	/**
	 * Tar emot betalningen, uppdaterar f�rs�ljningsregister, l�gger in betalningen i kassask�pet,
	 * skickar k�pinformationen till extern bokf�ringssystem, uppdaterar lager med de s�lda varor
	 * och skriver ut kvitto
	 * @param summaAvPengar - summa av pengar som kunden betalar med
	 * @return v�xel som kunden ska beh�lla
	 */
	public static double betalning(double summaAvPengar)
	{
		F�rs�ljningsregister.uppdateraInt�kter(uppdateradK�pinformation.getTotalSumma());
		Kassask�p.l�ggI(uppdateradK�pinformation.getTotalSumma());
		ExternBokf�ringssystem.sparaUppgifterOm(uppdateradK�pinformation);
		Lagerkatalog.uppdateraLager(listaAvRegistreradeVaror);
		double v�xel = Kalkylator.ber�knaDifferens(summaAvPengar, 
				uppdateradK�pinformation.getTotalSumma());
		Kvitto kvitto = Kvitto.skapaKvitto(uppdateradK�pinformation, summaAvPengar, v�xel);
		Kvittoskrivare.skrivUt(kvitto);
		
		return v�xel;
	}
	
	/**
	 * Registrerar varan som s�ld vara och uppdaterar k�pinformation
	 * @param artikelnummer - varan som ska registreras
	 * @return <code>K�pinformation<code>
	 */
	public static K�pinformation registrera(String artikelnummer)
	{
		VarorDTO varaSomSkaRegistreras = Lagerkatalog.hitta(artikelnummer);
		l�ggIListan(varaSomSkaRegistreras);
		uppdateradK�pinformation = new K�pinformation(listaAvRegistreradeVaror, 
				Kalkylator.ber�knaTotalPris(listaAvRegistreradeVaror), 
				Kalkylator.ber�knaTotalMoms(listaAvRegistreradeVaror));
		return uppdateradK�pinformation;
	}
	
	/**
	 * L�gger till varan som ska registreras i listan <code>listaAvRegistreradeVaror<code>, 
	 * om varan redan finns i listan s� �kas bara antalet med 1.
	 * @param vara - varan som ska registreras
	 */
	public static void l�ggIListan(VarorDTO vara)
	{
		for(RegistreradeVarorDTO registreradeVara : listaAvRegistreradeVaror)
			if(vara.matchar(registreradeVara.getArtikelnummer()))
			{
				registreradeVara.setAntal(registreradeVara.getAntal() + 1);
				return;
			}
		
		listaAvRegistreradeVaror.add(new RegistreradeVarorDTO(vara.getNamn(), vara.getArtikelnummer()
					,vara.getPris(), vara.getMomssats(), 1));
	}
}
