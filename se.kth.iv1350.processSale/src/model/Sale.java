package model;
import java.util.ArrayList;
import java.util.List;

/**
 * Inneh�ller all information om ett k�p
 */
public class Sale
{
	public  List<RegisteredItemDTO> listWithRegisteredItems = new ArrayList<>();
	private double totalToPay;
	private double totalVat;

	/**
	 * skapar en instans
	 * @param listWithRegisteredItems - en lista p� alla varor som �r registrerade p� s�lda varor
	 * @param totalToPay - totala priset p� de registrerade varorna(inkluderar moms)
	 * @param totalVat - totala momsen p� de registrerade varorna
	 */
	public Sale(List<RegisteredItemDTO> listWithRegisteredItems, double totalToPay, double totalVat)
	{
		this.listWithRegisteredItems = listWithRegisteredItems;
		this.totalToPay = totalToPay;
		this.totalVat = totalVat;
	}

	/**
	 * Ber�knar totala priset inklusive moms p� de varor som �r registrerade som s�lda varor
	 * @param listWithRegisteredItems - lista av varor som ska ber�knas
	 * @return totala priset p� listan
	 */
	public static double calculatePrice(List<RegisteredItemDTO> listWithRegisteredItems)
	{
		double total = 0;
		for(RegisteredItemDTO item : listWithRegisteredItems)
			total = total + (item.getPrice() + item.getPrice() * item.getVatRate()) * item.getAmount();
		return total;
	}

	/**
	 * Ber�knar totala momsen p� de varor som �r registrerade som s�lda varor
	 * @param listWithRegisteredItems - lista av varor som ska ber�knas
	 * @return totala momsen
	 */
	public static double calculateVat(List<RegisteredItemDTO> listWithRegisteredItems)
	{
		double totalVat = 0;
		for(RegisteredItemDTO item : listWithRegisteredItems)
			totalVat = totalVat + (item.getPrice() * item.getVatRate()) * item.getAmount();
		return totalVat;
	}
	/**
	 * Ber�knar differensen mellan tv� v�rden och f�r fram v�xel
	 * @param totalPaid - summa av pengar som kunden betalar
	 * @param total - totala priset av hela k�pet
	 * @return v�xel
	 */
	public static double calculateDifference(double totalPaid, double totalToPay)
	{
		return totalPaid - totalToPay;
	}
	/*
	* add to list
	*/

	public static void addToList(ItemDTO item)
	{
		for(RegisteredItemsDTO registeredItem : listWithRegisteredItems)
			if(item.articleNumber == registeredItem.getArticleNumber())
			{
				registeredItem.setAmount(registeredItem.getAmount() + 1);
				return;
			}

		listWithRegisteredItems.add(new RegisteredItemsDTO(item.getName(), item.getArticleNumber()
					,item.getPrice(), item.getVatRate(), 1));
	}
	/**
	 * H�mtar alla varor som finns i listan av registrerade varor
	 * @return - lista av registrerade varor
	 */
	public List<RegisteredItemDTO> getListWithRegisteredItems()
	{
		return this.listWithRegisteredItems;
	}
	/**
	 * H�mtar v�rdet av totala summan inkluderar moms av de registrerade varor i listan
	 * @return totala summan inkluderar moms
	 */
	public double getTotalToPay()
	{
		return this.totalToPay;
	}
	/**
	 * H�mtar v�rdet av totala moms av de registrerade varor i listan
	 * @return totala moms
	 */
	public double getTotalVat()
	{
		return this.totalVat;
	}
	/**
	 * Skriver �ver listan med det nya lista av registrerade varor
	 * @param nya lista av registrerade varor
	 */
	public void setListWithRegisteredItems(List<RegisteredItemDTO> listWithRegisteredItems)
	{
		this.listWithRegisteredItems = listWithRegisteredItems;
	}
	/**
	 * skriver �ver summan med det nya summan
	 * @param nya summa
	 */
	public void setTotalToPay(double totalToPay)
	{
		this.totalToPay = totalToPay;
	}
	/**
	 * skriver �ver totalmomsen med det nya momsen
	 * @param nya momsen
	 */
	public void setTotalVat(double totalVat)
	{
		this.totalVat = totalVat;
	}
	/**
	 * Skriver om k�pinformationen till en string med specifik information,
	 * kommer att anv�ndas n�r ett kvitto ska bildas
	 */
	public String toString()
	{
		return this.listWithRegisteredItems + "Total: " + this.totalToPay +
				"\n" + "Vat: " + this.totalVat + "\n";
	}
}
