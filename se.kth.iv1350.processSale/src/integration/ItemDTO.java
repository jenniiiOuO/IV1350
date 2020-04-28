package integration;

/**
 *Inneh�ller all information om en specifik vara.
 */
public class ItemDTO
{
	private final String name;
	private final String articleNumber;
	private final double price;
	private final double vatRate;

	/**
	 * Metoden skapar en ny instans som ska representera en vara
	 * @param name - nameet p� varan
	 * @param articleNumber - articleNumber p� varan
	 * @param price - priceet p� varan inkluderar moms
	 * @param vatRate - s�ger andel av priceet som �r moms, i faktor
	 */
	public ItemDTO(String name, String articleNumber, double price, double vatRate)
	{
		this.name = name;
		this.articleNumber = articleNumber;
		this.price = price;
		this.vatRate = vatRate;
	}

	/**
	 * H�mtar v�rdet av nameet p� varan
	 * @return v�rdet av nameet p� varan
	 */
	public String getname()
	{
		return this.name;
	}
	/**
	 * H�mtar v�rdet av articleNumber p� varan
	 * @return v�rdet av articleNumber p� varan
	 */
	public String getarticleNumber()
	{
		return this.articleNumber;
	}
	/**
	 * H�mtar v�rdet av priceet p� varan
	 * @return v�rdet av priceet p� varan
	 */
	public double getprice()
	{
		return this.price;
	}
	/**
	 * H�mtar v�rdet av vatRateen p� varan
	 * @return v�rdet av vatRateen p� varan
	 */
	public double getvatRate()
	{
		return this.vatRate;
	}
