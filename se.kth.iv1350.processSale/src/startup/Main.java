package startup;

import view.View;
import controller.Controller;
import integration.RegistryCreator;
import integration.SaleRegistry;
import integration.Printer;
import integration.AccountingSystem;

/**
 * Inneh�ller <code>Main<code>, utf�r all startup som kr�vs f�r programmet
 *
 */
public class Main {

	/**
	 * Startar programmet
	 * @param args
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
