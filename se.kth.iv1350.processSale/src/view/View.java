package view;

import controller.Controller;
import model.K�pinformation;

/**
 * Denna klass ska f�rest�lla hela view eftersom att det h�r progammet har ingen view.
 *
 */
public class View 
{
	private Controller controller;
	
	/**
	 * Skapar en ny instans
	 * @param controller - controller som anv�nds f�r alla operationer
	 */
	public View(Controller controller)
	{
		this.controller = controller;
	}
	
	/**
	 * Ska simulera anv�ndarens input och hur de framkallar olika system operationer
	 */
	public void simulering()
	{
		String[] varorSomSkaRegistreras = {"3678", "3678", "0054"};
		
		for(int i = 0; i < varorSomSkaRegistreras.length; i++)
		{
			K�pinformation uppdateradK�pinformation = Controller.registrera(varorSomSkaRegistreras[i]);
			System.out.println(uppdateradK�pinformation);
		}
		double v�xel = Controller.betalning(100.0);
	}
}
