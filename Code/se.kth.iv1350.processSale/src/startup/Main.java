package startup;

import view.View;
import controller.Controller;
import integration.Registerskapare;

/**
 * Innehåller <code>Main<code>, utför all startup som krävs för programmet
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
