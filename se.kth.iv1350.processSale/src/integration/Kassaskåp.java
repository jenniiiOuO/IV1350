package integration;

/**
 * Innehåller information om hur mycket kontant som finns i butikens kassaskåp
 */
public class Kassaskåp 
{
	private static double kontanter;
	
	/**
	 * Spara kontanter i kassaskåpet
	 * @param summaAvPengar - kontanter som ska sparas i kassaskåpet
	 */
	public static void läggI(double summaAvPengar)
	{
		kontanter = kontanter + summaAvPengar;
	}
}
