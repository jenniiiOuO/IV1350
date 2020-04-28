package controller;

import java.util.ArrayList;
import java.util.List;

import integration.RegistryCreator;
import integration.Inventory;
//import integration.MemberSystem;
//import integration.DiscountSystem;
//import integration.Discount;
//import integration.MemberDTO;
import integration.AccountingSystem;
import integration.SaleRegistry;
import integration.Printer;
import integration.ItemDTO;
import model.Sale;
import model.RegisteredItemDTO;
import model.Receipt;

/**
 * Controller f�r programmet, all upprop av metoden fr�n model g�rs h�r
 */
public class Controller
{
	private Inventory inven;
	// private DiscountSystem dissys;
	// private MemberSystem memsys;

	// private static List<RegistreradeVarorDTO> listWithRegisteredItems = new ArrayList<>();
	// private static Sale paymentInfo;

	/**
	 * Skapar en instans
	 */
	public Controller(RegistryCreator regiC, SaleRegistry saleR, Printer pr, AccountingSystem accS)
	{
		this.inven = regiC.getInventory();
		// this.dissys = regiC.getDiscountSystem();
		// this.memsys = regiC.getMemberSystem();
	}

	/**
	 * Tar emot betalningen, uppdaterar f�rs�ljningsregister, l�gger in betalningen i kassask�pet,
	 * skickar k�pinformationen till extern bokf�ringssystem, uppdaterar lager med de s�lda varor
	 * och skriver ut receipt
	 * @param totalPaid - summa av pengar som kunden betalar med
	 * @return change som kunden ska beh�lla
	 */
	public static double payment(double totalPaid)
	{
		//need to declare paymentInfo in Sale
		saleR.updateBalance(paymentInfo.getTotalToPay());
		accS.updateAccounting(paymentInfo);
		//need to get list from sale
		inven.updateInventory(listWithRegisteredItems);
		double change = Sale.calculateDifference(totalPaid,
				paymentInfo.getTotalToPay());
		Receipt receipt = Receipt.createReceipt(paymentInfo, totalPaid, change);
		pr.printReceipte(receipt);

		return change;
	}

	/**
	 * Registrerar varan som s�ld vara och uppdaterar k�pinformation
	 * @param articleNumber - varan som ska registreras
	 * @return <code>Sale<code>
	 */
	public static Sale registrera(String articleNumber)
	{
		ItemDTO itemToBeRegistered = inven.find(articleNumber);
		//add to list in Invertory now
		addToList(itemToBeRegistered);
		paymentInfo = new Sale(listWithRegisteredItems,
				Sale.calculatePrice(listWithRegisteredItems),
				Sale.calculateVat(listWithRegisteredItems));
		return paymentInfo;
	}
	//need a view end sale method
}
