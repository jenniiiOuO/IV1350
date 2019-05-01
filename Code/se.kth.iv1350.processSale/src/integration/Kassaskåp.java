package integration;

/**
 * Inneh�ller information om hur mycket kontant som finns i butikens kassask�p
 */
public class Kassask�p 
{
	private static double kontanter;
	
	/**
	 * Spara kontanter i kassask�pet
	 * @param summaAvPengar - kontanter som ska sparas i kassask�pet
	 */
	public static void l�ggI(double summaAvPengar)
	{
		kontanter = kontanter + summaAvPengar;
	}
}
