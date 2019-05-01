package model;

import java.util.List;

/**
 * Innehåller alla metoder som kommer att användas till att utföra beräkningar
 */
public class Kalkylator 
{
	/**
	 * Beräknar totala priset inklusive moms på de varor som är registrerade som sålda varor
	 * @param listaAvRegistreradeVaror - lista av varor som ska beräknas
	 * @return totala priset på listan
	 */
	public static double beräknaTotalPris(List<RegistreradeVarorDTO> listaAvRegistreradeVaror)
	{
		double totalPris = 0;
		for(RegistreradeVarorDTO vara : listaAvRegistreradeVaror)
			totalPris = totalPris + (vara.getPris() + vara.getPris() * vara.getMomssats()) * vara.getAntal();
		return totalPris;
	}
	
	/**
	 * Beräknar totala momsen på de varor som är registrerade som sålda varor
	 * @param listaAvRegistreradeVaror - lista av varor som ska beräknas
	 * @return totala momsen
	 */
	public static double beräknaTotalMoms(List<RegistreradeVarorDTO> listaAvRegistreradeVaror)
	{
		double totalMoms = 0;
		for(RegistreradeVarorDTO vara : listaAvRegistreradeVaror)
			totalMoms = totalMoms + (vara.getPris() * vara.getMomssats()) * vara.getAntal();
		return totalMoms;
	}
	/**
	 * Beräknar differensen mellan två värden och får fram växel
	 * @param summaAvPengar - summa av pengar som kunden betalar
	 * @param total - totala priset av hela köpet
	 * @return växel
	 */
	public static double beräknaDifferens(double summaAvPengar, double total)
	{
		return summaAvPengar - total;
	}
}
