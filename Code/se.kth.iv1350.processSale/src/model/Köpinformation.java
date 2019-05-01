package model;
import java.util.ArrayList;
import java.util.List;

/**
 * Innehåller all information om ett köp
 */
public class Köpinformation 
{
	public  List<RegistreradeVarorDTO> listaAvRegistreradeVaror = new ArrayList<>();
	private double totalSumma;
	private double totalMoms;
	
	/**
	 * skapar en instans
	 * @param listaAvRegistreradeVaror - en lista på alla varor som är registrerade på sålda varor
	 * @param totalSumma - totala priset på de registrerade varorna(inkluderar moms)
	 * @param totalMoms - totala momsen på de registrerade varorna
	 */
	public Köpinformation(List<RegistreradeVarorDTO> listaAvRegistreradeVaror, double totalSumma, double totalMoms)
	{
		this.listaAvRegistreradeVaror = listaAvRegistreradeVaror;
		this.totalSumma = totalSumma;
		this.totalMoms = totalMoms;
	}
	
	/**
	 * Hämtar alla varor som finns i listan av registrerade varor
	 * @return - lista av registrerade varor
	 */
	public List<RegistreradeVarorDTO> getListaAvRegistreradeVaror()
	{
		return this.listaAvRegistreradeVaror;
	}
	/**
	 * Hämtar värdet av totala summan inkluderar moms av de registrerade varor i listan
	 * @return totala summan inkluderar moms
	 */
	public double getTotalSumma()
	{
		return this.totalSumma;
	}
	/**
	 * Hämtar värdet av totala moms av de registrerade varor i listan
	 * @return totala moms
	 */
	public double getTotalMoms()
	{
		return this.totalMoms;
	}
	/**
	 * Skriver över listan med det nya lista av registrerade varor
	 * @param nya lista av registrerade varor
	 */
	public void setListaAvRegistreradeVaror(List<RegistreradeVarorDTO> listaAvRegistreradeVaror)
	{
		this.listaAvRegistreradeVaror = listaAvRegistreradeVaror;
	}
	/**
	 * skriver över summan med det nya summan
	 * @param nya summa
	 */
	public void setTotalSumma(double totalSumma)
	{
		this.totalSumma = totalSumma;
	}
	/**
	 * skriver över totalmomsen med det nya momsen
	 * @param nya momsen
	 */
	public void setTotalMoms(double totalMoms)
	{
		this.totalMoms = totalMoms;
	}
	/**
	 * Skriver om köpinformationen till en string med specifik information, 
	 * kommer att användas när ett kvitto ska bildas
	 */
	public String toString()
	{
		return this.listaAvRegistreradeVaror + "Total: " + this.totalSumma + 
				"\n" + "Varav moms: " + this.totalMoms + "\n";
	}
}
