package integration;

import model.Receipt;

/**
 * Inneh�ller metoder f�r att skriva ut kvitto
 */
public class Printer
{
	/**
	 * Skriver ut kvitto
	 * @param receipt - kvitto som ska skrivas ut
	 */
	public static void printReceipt(Receipt receipt)
	{
		System.out.println(receipt);
	}
}
