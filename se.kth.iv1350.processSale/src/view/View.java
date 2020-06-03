package view;

import java.util.Locale;
import java.util.Scanner;

import controller.Controller;
import controller.OperationNotWorkException;
import integration.DoesNotExistException;
import model.Sale;


public class View
{
	private Controller contr;

	public View(Controller contr)
	{
		this.contr = contr;
		this.contr.addTotalRevenueObserver(new TotalRevenueView());
	}

	/*
	 * simulate a sale
	 */
	public void simulator() throws OperationNotWorkException 
	{
		String[] itemNeededToRegister = {"3678", "3678", "3678", "0054"};
		contr.startSale();
		
		for(int i = 0; i < itemNeededToRegister.length; i++)
		{
			try {
				Sale info = contr.register(itemNeededToRegister[i]);
				System.out.println(info);
			}catch(DoesNotExistException exc) {
				System.out.println(exc);
			}catch(OperationNotWorkException exc) {
				System.out.println(exc);
			}
		}
		
		double toPay = contr.endSale();
		
		System.out.println("Total to pay: " + toPay);
		Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
		System.out.println("Enter paid amount: ");
		double cash = scanner.nextDouble();
		System.out.println("");
		double change = contr.payment(cash);
		
		String[] itemNeededToRegister2 = {"5997", "3678", "5997", "0054", "1566"};
		contr.startSale();
		
		for(int i = 0; i < itemNeededToRegister2.length; i++)
		{
			try {
				Sale info = contr.register(itemNeededToRegister2[i]);
				System.out.println(info);
			}catch(DoesNotExistException exc) {
				System.out.println(exc);
			}catch(OperationNotWorkException exc) {
				System.out.println(exc);
			}
		}
		
		toPay = contr.endSale();
		
		System.out.println("Total to pay: " + toPay);
		scanner = new Scanner(System.in).useLocale(Locale.US);
		System.out.println("Enter paid amount: ");
		cash = scanner.nextDouble();
		System.out.println("");
		change = contr.payment(cash);
		
	}
}
