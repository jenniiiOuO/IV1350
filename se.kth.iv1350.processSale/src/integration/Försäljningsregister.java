package integration;

/**
 * Inneh�ller metoder som tar fram databaser om f�rs�ljning
 */
public class F�rs�ljningsregister 
{
	private static double int�kter;
	
	/**
	 * �kar int�kter i registret
	 * @param int�kter - int�kter som ska �kas med
	 */
	public static void uppdateraInt�kter(double int�kt)
	{
		int�kter = int�kter + int�kt;
	}
}
