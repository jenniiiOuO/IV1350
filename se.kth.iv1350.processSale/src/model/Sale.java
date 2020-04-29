package model;
import java.util.ArrayList;
import java.util.List;

import integration.ItemDTO;


public class Sale
{
	public List<RegisteredItemDTO> listWithRegisteredItems = new ArrayList<>();
	private double totalToPay;
	private double totalVat;

	public Sale(List<RegisteredItemDTO> listWithRegisteredItems, double totalToPay, double totalVat)
	{
		this.listWithRegisteredItems = listWithRegisteredItems;
		this.totalToPay = totalToPay;
		this.totalVat = totalVat;
	}

	public double calculatePrice()
	{
		double total = 0;
		for(RegisteredItemDTO item : this.listWithRegisteredItems)
			total = total + (item.getPrice() + item.getPrice() * item.getVatRate()) * item.getAmount();
		return total;
	}

	public double calculateVat()
	{
		double totalVat = 0;
		for(RegisteredItemDTO item : this.listWithRegisteredItems)
			totalVat = totalVat + (item.getPrice() * item.getVatRate()) * item.getAmount();
		return totalVat;
	}

	public double calculateDifference(double totalPaid, double totalToPay)
	{
		return totalPaid - totalToPay;
	}

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
