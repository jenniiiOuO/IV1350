package integration;

/**
 * Innehåller metoder som tar fram databaser om försäljning
 */
public class Försäljningsregister 
{
	private static double intäkter;
	
	/**
	 * ökar intäkter i registret
	 * @param intäkter - intäkter som ska ökas med
	 */
	public static void uppdateraIntäkter(double intäkt)
	{
		intäkter = intäkter + intäkt;
	}
}
