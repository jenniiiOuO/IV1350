package startup;

import controller.Controller;
import integration.AccountingSystem;
import integration.Printer;
import integration.RegistryCreator;
import integration.SaleRegistry;
import view.View;

public class Main {

	/*
	 * main, create instance of the external systems in order to be able to interact with them in the sale
	 */
	public static void main(String[] args)
	{
		RegistryCreator regiC = new RegistryCreator();
		SaleRegistry saleR = new SaleRegistry();
		Printer pr = new Printer();
		AccountingSystem accS = new AccountingSystem();
		Controller contr = new Controller(regiC, saleR, pr, accS);
		new View(contr).simulator();
	}
}
