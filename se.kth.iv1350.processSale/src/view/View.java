package view;

import controller.Controller;
import model.Sale;


public class View
{
	private Controller contr;

	public View(Controller contr)
	{
		this.contr = contr;
	}

	public void simulator()
	{
		String[] itemNeededToRegister = {"3678", "3678", "0054"};
		contr.startSale();
		
		for(int i = 0; i < itemNeededToRegister.length; i++)
		{
			Sale info = contr.register(itemNeededToRegister[i]);
			System.out.println(info);
		}
		
		double change = contr.endSale();
	}
}
