package integration;


public class ItemDTO
{
	private String name;
	private String articleNumber;
	private double price;
	private double vatRate;


	public ItemDTO(String name, String articleNumber, double price, double vatRate)
	{
		this.name = name;
		this.articleNumber = articleNumber;
		this.price = price;
		this.vatRate = vatRate;
	}

	public String getName()
	{
		return this.name;
	}

	public String getArticleNumber()
	{
		return this.articleNumber;
	}
	
	public double getPrice()
	{
		return this.price;
	}

	public double getVatRate()
	{
		return this.vatRate;
	}

	public void setArticleNumber(String artNr) {
		this.articleNumber = artNr;
		
	}
}
