package model;
import java.util.ArrayList;
import java.util.List;

/**
 * Inneh�ller all information om ett k�p
 */
public class K�pinformation 
{
	public  List<RegistreradeVarorDTO> listaAvRegistreradeVaror = new ArrayList<>();
	private double totalSumma;
	private double totalMoms;
	
	/**
	 * skapar en instans
	 * @param listaAvRegistreradeVaror - en lista p� alla varor som �r registrerade p� s�lda varor
	 * @param totalSumma - totala priset p� de registrerade varorna(inkluderar moms)
	 * @param totalMoms - totala momsen p� de registrerade varorna
	 */
	public K�pinformation(List<RegistreradeVarorDTO> listaAvRegistreradeVaror, double totalSumma, double totalMoms)
	{
		this.listaAvRegistreradeVaror = listaAvRegistreradeVaror;
		this.totalSumma = totalSumma;
		this.totalMoms = totalMoms;
	}
	
	/**
	 * H�mtar alla varor som finns i listan av registrerade varor
	 * @return - lista av registrerade varor
	 */
	public List<RegistreradeVarorDTO> getListaAvRegistreradeVaror()
	{
		return this.listaAvRegistreradeVaror;
	}
	/**
	 * H�mtar v�rdet av totala summan inkluderar moms av de registrerade varor i listan
	 * @return totala summan inkluderar moms
	 */
	public double getTotalSumma()
	{
		return this.totalSumma;
	}
	/**
	 * H�mtar v�rdet av totala moms av de registrerade varor i listan
	 * @return totala moms
	 */
	public double getTotalMoms()
	{
		return this.totalMoms;
	}
	/**
	 * Skriver �ver listan med det nya lista av registrerade varor
	 * @param nya lista av registrerade varor
	 */
	public void setListaAvRegistreradeVaror(List<RegistreradeVarorDTO> listaAvRegistreradeVaror)
	{
		this.listaAvRegistreradeVaror = listaAvRegistreradeVaror;
	}
	/**
	 * skriver �ver summan med det nya summan
	 * @param nya summa
	 */
	public void setTotalSumma(double totalSumma)
	{
		this.totalSumma = totalSumma;
	}
	/**
	 * skriver �ver totalmomsen med det nya momsen
	 * @param nya momsen
	 */
	public void setTotalMoms(double totalMoms)
	{
		this.totalMoms = totalMoms;
	}
	/**
	 * Skriver om k�pinformationen till en string med specifik information, 
	 * kommer att anv�ndas n�r ett kvitto ska bildas
	 */
	public String toString()
	{
		return this.listaAvRegistreradeVaror + "Total: " + this.totalSumma + 
				"\n" + "Varav moms: " + this.totalMoms + "\n";
	}
}
