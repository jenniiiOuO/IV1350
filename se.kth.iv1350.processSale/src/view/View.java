package view;

import controller.Controller;
import model.Sale;

/**
 * Denna klass ska f�rest�lla hela view eftersom att det h�r progammet har ingen view.
 *
 */
public class View
{
	private Controller contr;

	/**
	 * Skapar en ny instans
	 * @param controller - controller som anv�nds f�r alla operationer
	 */
	public View(Controller contr)
	{
		this.contr = contr;
	}

	/**
	 * Ska simulera anv�ndarens input och hur de framkallar olika system operationer
	 */
	public void simulator()
	{
		String[] itemNeededToRegister = {"3678", "3678", "0054"};

		for(int i = 0; i < itemNeededToRegister.length; i++)
		{
			Sale paymentInfo = Controller.register(itemNeededToRegister[i]);
			System.out.println(paymentInfo);
		}
		double change = Controller.payment(100.0);
	}
}
