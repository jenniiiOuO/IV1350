package model;

import java.util.List;

/**
 * Inneh�ller alla metoder som kommer att anv�ndas till att utf�ra ber�kningar
 */
public class Kalkylator 
{
	/**
	 * Ber�knar totala priset inklusive moms p� de varor som �r registrerade som s�lda varor
	 * @param listaAvRegistreradeVaror - lista av varor som ska ber�knas
	 * @return totala priset p� listan
	 */
	public static double ber�knaTotalPris(List<RegistreradeVarorDTO> listaAvRegistreradeVaror)
	{
		double totalPris = 0;
		for(RegistreradeVarorDTO vara : listaAvRegistreradeVaror)
			totalPris = totalPris + (vara.getPris() + vara.getPris() * vara.getMomssats()) * vara.getAntal();
		return totalPris;
	}
	
	/**
	 * Ber�knar totala momsen p� de varor som �r registrerade som s�lda varor
	 * @param listaAvRegistreradeVaror - lista av varor som ska ber�knas
	 * @return totala momsen
	 */
	public static double ber�knaTotalMoms(List<RegistreradeVarorDTO> listaAvRegistreradeVaror)
	{
		double totalMoms = 0;
		for(RegistreradeVarorDTO vara : listaAvRegistreradeVaror)
			totalMoms = totalMoms + (vara.getPris() * vara.getMomssats()) * vara.getAntal();
		return totalMoms;
	}
	/**
	 * Ber�knar differensen mellan tv� v�rden och f�r fram v�xel
	 * @param summaAvPengar - summa av pengar som kunden betalar
	 * @param total - totala priset av hela k�pet
	 * @return v�xel
	 */
	public static double ber�knaDifferens(double summaAvPengar, double total)
	{
		return summaAvPengar - total;
	}
}
