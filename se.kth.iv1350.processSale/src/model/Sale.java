package model;
import java.util.ArrayList;
import java.util.List;

import integration.ItemDTO;


public class Sale
{
	public List<RegisteredItemDTO> listWithRegisteredItems = new ArrayList<>();
	private double totalToPay;
	private double totalVat;
	
	/*
	 * creates an instance of a sale
	 */
	public Sale()
	{
		List<RegisteredItemDTO> list = new ArrayList<>(); 
		this.listWithRegisteredItems = list;
		this.totalToPay = 0;
		this.totalVat = 0;
	}
	
	/*
	 * Calculate total price of all registered items in a sale
	 * @return total - total price including vat
	 */
	public double calculatePrice()
	{
		double total = 0;
		for(RegisteredItemDTO item : this.listWithRegisteredItems)
			total = total + (item.getPrice() + item.getPrice() * item.getVatRate()) * item.getAmount();
		return total;
	}

	/*
	 * Calculate total vat of all registered items in a sale
	 * @return totalVat - total vat of all registered items
	 */
	public double calculateVat()
	{
		double totalVat = 0;
		for(RegisteredItemDTO item : this.listWithRegisteredItems)
			totalVat = totalVat + (item.getPrice() * item.getVatRate()) * item.getAmount();
		return totalVat;
	}

	/*
	 * calculate the difference between @param totalPaid and @param totalToPay and return change
	 */
	public static double calculateDifference(double totalPaid, double totalToPay)
	{
		return totalPaid - totalToPay;
	}

	/*
	 * add an item in to the list of registered items
	 */
	public void addToList(ItemDTO item)
	{
		for(RegisteredItemDTO registeredItem : this.listWithRegisteredItems)
			if(item.getArticleNumber() == registeredItem.getArticleNumber())
			{
				registeredItem.setAmount(registeredItem.getAmount() + 1);
				return;
			}

		this.listWithRegisteredItems.add(new RegisteredItemDTO(item.getName(), item.getArticleNumber()
					,item.getPrice(), item.getVatRate(), 1));
	}

	public List<RegisteredItemDTO> getListWithRegisteredItems()
	{
		return this.listWithRegisteredItems;
	}

	public double getTotalToPay()
	{
		return this.totalToPay;
	}

	public double getTotalVat()
	{
		return this.totalVat;
	}

	public void setListWithRegisteredItems(List<RegisteredItemDTO> listWithRegisteredItems)
	{
		this.listWithRegisteredItems = listWithRegisteredItems;
	}

	public void setTotalToPay(double totalToPay)
	{
		this.totalToPay = totalToPay;
	}

	public void setTotalVat(double totalVat)
	{
		this.totalVat = totalVat;
	}

	public String toString()
	{
		return this.listWithRegisteredItems + "Total: " + this.totalToPay +
				"\n" + "Vat: " + this.totalVat + "\n";
	}
}
