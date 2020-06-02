package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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

	/*
	 * Create an instance of controller
	 */
	public Controller(RegistryCreator regiC, SaleRegistry saleR, Printer pr, AccountingSystem accS)
	{
		this.inven = regiC.getInventory();
		this.saleR = saleR;
		this.pr = pr;
		this.accS = accS;

	}

	/*
	 * Start a new sale
	 */
	public void startSale()
	{
		List<RegisteredItemDTO> list = new ArrayList<>();
		double totalToPay = 0;
		double totalVat = 0;
		this.sale = new Sale(list, totalToPay, totalVat);
	}

	/*
	 * End the sale
	 * @return toPay - Amount of money the customer needed to pay
	 */
	public double endSale()
	{
		double toPay = sale.getTotalToPay();
		return toPay;
	}

	/*
	 * Do the payment, contact to all the external systems after payment and save the sale info
	 * @param totalPaid - the amount of money the customer paid
	 * @return change - the change
	 */
	public double payment(double totalPaid)
	{
		saleR.updateBalance(sale.getTotalToPay());
		accS.updateAccounting(sale);
		inven.updateInventory(sale.getListWithRegisteredItems());
		double change = Sale.calculateDifference(totalPaid,
				sale.getTotalToPay());
		Receipt receipt = Receipt.createReceipt(sale, totalPaid, change);
		pr.printReceipt(receipt);

		return change;
	}

	/*
	 * Register an item
	 * @param articleNumber - article number of an item
	 * @return sale - current sale info
	 * @throws DoesNotExistException if there is no item with such artNr.
	 * @throws OperationNotWorkException when an operation fails.
	 */
	public Sale register(String articleNumber)
	{
		ItemDTO itemToBeRegistered = inven.find(articleNumber);
		sale.addToList(itemToBeRegistered);
		double price = sale.calculatePrice();
		double vat = sale.calculateVat();
		sale.setTotalToPay(price);
		sale.setTotalVat(vat);

		return sale;
	}
}
