package model;

import java.time.LocalDateTime;

public class Receipt {
	private Sale paymentInfo;
	private double totalPaid;
	private double change;
	private static String date;
	private static String shopName = "Metro Detro";
	private static String shopAddress = "Buy Buy gate 1";

	/*
	 * create an instance
	 */
	public Receipt(Sale paymentInfo, double totalPaid, double change, String date, String shopName,
			String shopAddress) {
		this.paymentInfo = paymentInfo;
		this.totalPaid = totalPaid;
		this.change = change;
		this.date = date;
	}

	/*
	 * create a receipt with date on end sale and info about the sale
	 */
	public static Receipt createReceipt(Sale paymentInfo, double totalPaid, double change) {
		LocalDateTime lokaldate = LocalDateTime.now();
		date = lokaldate.toString();
		return new Receipt(paymentInfo, totalPaid, change, date, shopName, shopAddress);

	}

	public String toString() {
		return "Receipt" + "\n" + this.shopName + "\n" + this.shopAddress + "\n" + date + "\n" + paymentInfo + "\n"
				+ "Paid: " + this.totalPaid + "\n" + "change: " + this.change + "\n";
	}
}
