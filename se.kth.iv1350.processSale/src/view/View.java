package view;

import controller.Controller;
import model.Köpinformation;

/**
 * Denna klass ska föreställa hela view eftersom att det här progammet har ingen view.
 *
 */
public class View 
{
	private Controller controller;
	
	/**
	 * Skapar en ny instans
	 * @param controller - controller som används för alla operationer
	 */
	public View(Controller controller)
	{
		this.controller = controller;
	}
	
	/**
	 * Ska simulera användarens input och hur de framkallar olika system operationer
	 */
	public void simulering()
	{
		String[] varorSomSkaRegistreras = {"3678", "3678", "0054"};
		
		for(int i = 0; i < varorSomSkaRegistreras.length; i++)
		{
			Köpinformation uppdateradKöpinformation = Controller.registrera(varorSomSkaRegistreras[i]);
			System.out.println(uppdateradKöpinformation);
		}
		double växel = Controller.betalning(100.0);
	}
}
