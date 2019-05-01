package controller;

import java.util.ArrayList;
import java.util.List;

import integration.ExternBokföringssystem;
import integration.Försäljningsregister;
import integration.Kassaskåp;
import integration.Kvittoskrivare;
import integration.Lagerkatalog;
import integration.Registerskapare;
import integration.VarorDTO;
import model.Köpinformation;
import model.RegistreradeVarorDTO;
import model.Kalkylator;
import model.Kvitto;

/**
 * Controller för programmet, all upprop av metoden från model görs här
 */
public class Controller 
{
	private Lagerkatalog lagerkatalog;
	private static List<RegistreradeVarorDTO> listaAvRegistreradeVaror = new ArrayList<>();
	private static Köpinformation uppdateradKöpinformation;
	
	/**
	 * Skapar en instans
	 */
	public Controller(Registerskapare registerskapare)
	{
		this.lagerkatalog = registerskapare.getLagerkatalog();
	}
	
	/**
	 * Tar emot betalningen, uppdaterar försäljningsregister, lägger in betalningen i kassaskåpet,
	 * skickar köpinformationen till extern bokföringssystem, uppdaterar lager med de sålda varor
	 * och skriver ut kvitto
	 * @param summaAvPengar - summa av pengar som kunden betalar med
	 * @return växel som kunden ska behålla
	 */
	public static double betalning(double summaAvPengar)
	{
		Försäljningsregister.uppdateraIntäkter(uppdateradKöpinformation.getTotalSumma());
		Kassaskåp.läggI(uppdateradKöpinformation.getTotalSumma());
		ExternBokföringssystem.sparaUppgifterOm(uppdateradKöpinformation);
		Lagerkatalog.uppdateraLager(listaAvRegistreradeVaror);
		double växel = Kalkylator.beräknaDifferens(summaAvPengar, 
				uppdateradKöpinformation.getTotalSumma());
		Kvitto kvitto = Kvitto.skapaKvitto(uppdateradKöpinformation, summaAvPengar, växel);
		Kvittoskrivare.skrivUt(kvitto);
		
		return växel;
	}
	
	/**
	 * Registrerar varan som såld vara och uppdaterar köpinformation
	 * @param artikelnummer - varan som ska registreras
	 * @return <code>Köpinformation<code>
	 */
	public static Köpinformation registrera(String artikelnummer)
	{
		VarorDTO varaSomSkaRegistreras = Lagerkatalog.hitta(artikelnummer);
		läggIListan(varaSomSkaRegistreras);
		uppdateradKöpinformation = new Köpinformation(listaAvRegistreradeVaror, 
				Kalkylator.beräknaTotalPris(listaAvRegistreradeVaror), 
				Kalkylator.beräknaTotalMoms(listaAvRegistreradeVaror));
		return uppdateradKöpinformation;
	}
	
	/**
	 * Lägger till varan som ska registreras i listan <code>listaAvRegistreradeVaror<code>, 
	 * om varan redan finns i listan så ökas bara antalet med 1.
	 * @param vara - varan som ska registreras
	 */
	public static void läggIListan(VarorDTO vara)
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
