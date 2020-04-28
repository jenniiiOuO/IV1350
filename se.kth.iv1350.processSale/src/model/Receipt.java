package model;

import java.time.LocalDateTime;
/**
 * Inneh�ller all information som beh�vs f�r ett Receipt
 */
public class Receipt
{
	private Sale paymentInfo;
	private double totalPaid;
	private double change;
	private static String date;
	private static String shopName = "Metro Detro";
	private static String shopAddress = "Buy Buy gate 1";

	/**
	 * skapar en instans
	 * @param paymentInfo - en lista av all information om ett k�p
	 * @param change - change som kunden f�r tillbaka
	 * @param date - date p� k�pet
	 * @param shopName - butikens namn
	 * @param shopAddress - butikens adress
	 */
	public Receipt(Sale paymentInfo, double totalPaid, double change,
			String date, String shopName, String shopAddress)
	{
		this.paymentInfo = paymentInfo;
		this.totalPaid = totalPaid;
		this.change = change;
		this.date = date;
	}
	/**
	 * en metod som skapar ett Receipt
	 * @param paymentInfo - information om ett k�p
	 * @param totalPaid - summa av pengar som kunden betalar med
	 * @param change - change som kunden f�r tillbaka
	 * @return ett Receipt
	 */
	public static Receipt createReceipt(Sale paymentInfo, double totalPaid, double change)
	{
		LocalDateTime lokaldate = LocalDateTime.now();
		date = lokaldate.toString();
		return new Receipt(paymentInfo, totalPaid,change, date, shopName, shopAddress);

	}
	/**
	 * Skriver om Receiptt till en String
	 */
	public String toString()
	{
		return "Receipt" + "\n" + this.shopName + "\n" + this.shopAddress + "\n" + paymentInfo +
				"\n" + "Paid: " + this.totalPaid + "\n" + "change: " + this.change + "\n";
	}
}
