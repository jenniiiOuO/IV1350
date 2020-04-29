package model;


public class RegisteredItemDTO
{
	private String name;
	private String articleNumber;
	private double price;
	private double vatRate;
	private int amount;


	public RegisteredItemDTO(String name, String articleNumber,double price, double vatRate, int amount)
	{
		this.name = name;
		this.articleNumber = articleNumber;
		this.price = price;
		this.vatRate = vatRate;
		this.amount = amount;
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
	
	public int getAmount()
	{
		return this.amount;
	}


	public void setAmount(int amount)
	{
		this.amount = amount;
	}


	public String toString()
	{
		return this.name + "\t" + this.price + "\t" + this.amount + "\n";
	}
}
