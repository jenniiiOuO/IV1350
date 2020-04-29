package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import integration.AccountingSystem;
import integration.Inventory;
import integration.ItemDTO;
import integration.Printer;
import integration.RegistryCreator;
import integration.SaleRegistry;
import model.Receipt;
import model.RegisteredItemDTO;
import model.Sale;


public class Controller
{
	private Inventory inven;
	private SaleRegistry saleR;
	private Printer pr;
	private AccountingSystem accS;
	private Sale sale;
	// private DiscountSystem dissys;
	// private MemberSystem memsys;

	public Controller(RegistryCreator regiC, SaleRegistry saleR, Printer pr, AccountingSystem accS)
	{
		this.inven = regiC.getInventory();
		// this.dissys = regiC.getDiscountSystem();
		// this.memsys = regiC.getMemberSystem();
	}

	public void startSale()
	{
		List<RegisteredItemDTO> list = new ArrayList<>(); 
		double totalToPay = 0;
		double totalVat = 0;
		Sale sale = new Sale(list, totalToPay, totalVat);
	}
	
	public double endSale() 
	{
		double toPay = sale.getTotalToPay();
		System.out.println("Total to pay: " + toPay);
		Scanner scanner = new Scanner(System.in);
		double cash = scanner.nextDouble();
		double change = payment(cash);
		
		return change;
	}

	public double payment(double totalPaid)
	{
		saleR.updateBalance(sale.getTotalToPay());
		accS.updateAccounting(sale);
		inven.updateInventory(sale.getListWithRegisteredItems());
		double change = sale.calculateDifference(totalPaid,
				sale.getTotalToPay());
		Receipt receipt = Receipt.createReceipt(sale, totalPaid, change);
		pr.printReceipt(receipt);

		return change;
	}

	public Sale register(String articleNumber)
	{
		ItemDTO itemToBeRegistered = inven.find(articleNumber);
		sale.addToList(itemToBeRegistered);
		sale.calculatePrice();
		sale.calculateVat();
		
		return sale;
	}
}
