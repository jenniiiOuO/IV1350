package model;

/**
 * Inneh�ller all information om en specifik registrerade vara
 *
 */
public class RegisteredItemDTO
{
	private String name;
	private String articleNumber;
	private double price;
	private double vatRate;
	private int amount;

	/**
	 * Skapar en instans som ska f�rest�lla en registrerad vara
	 * @param name - nameet p� det registrerade vara
	 * @param price - priceet p� det registrerade vara (exkluderar moms)
	 * @param vatRate - vatRateen p� det regisrerade vara
	 * @param amount - amountet p� det regisrerade vara
	 */
	public RegisteredItemDTO(String name, String articleNumber,double price, double vatRate, int amount)
	{
		this.name = name;
		this.articleNumber = articleNumber;
		this.price = price;
		this.vatRate = vatRate;
		this.amount = amount;
	}

	/**
	 * H�mtar v�rdet av nameet p� det registrerade varan
	 * @return nameet p� det registrerade varan
	 */
	public String getName()
	{
		return this.name;
	}
	/**
	 * H�mtar v�rdet av artikelnummret p� det registrerade varan
	 * @return artikelnummret p� det registrerade varan
	 */
	public String getArticleNumber()
	{
		return this.articleNumber;
	}
	/**
	 * H�mtar v�rdet av priceet p� det registrerade varan
	 * @return priceet p� det registrerade varan
	 */
	public double getPrice()
	{
		return this.price;
	}
	/**
	 * H�mtar v�rdet av momsstatsen p� det registrerade varan
	 * @return vatRateen p� det registrerade varan
	 */
	public double getVatRate()
	{
		return this.vatRate;
	}
	/**
	 * H�mtar v�rdet av amountet p� det registrerade varan
	 * @return amountet p� det registrerade varan
	 */
	public int getAmount()
	{
		return this.amount;
	}

	/**
	 * �ndrar p� amountet p� det registrerade varan
	 * @param amount - det nya amountet
	 */
	public void setAmount(int amount)
	{
		this.amount = amount;
	}

	/**
	 * Skriver om det registrerade vara till en string med specifik information,
	 * kommer att anv�ndas n�r ett kvitto ska bildas
	 */
	public String toString()
	{
		return this.name + "\t" + this.price + "\t" + this.amount + "\n";
	}
}
