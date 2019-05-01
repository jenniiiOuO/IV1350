package startup;

import view.View;
import controller.Controller;
import integration.Registerskapare;

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
		Registerskapare registerskapare = new Registerskapare();
		Controller controller = new Controller(registerskapare);
		new View(controller).simulering();
	}

}
