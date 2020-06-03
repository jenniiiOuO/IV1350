package view;

import model.TotalRevenueObserver;
/*
 * Checks the user interface for the total income since the program start.
 */
public class TotalRevenueView implements TotalRevenueObserver{
	
	private double total;
	/*
	 * Creates a new instance.
	 */
	public TotalRevenueView() {
		total = 0;
	}
	@Override
	public void newTotalIncome(double paidAmount) {
		total = total + paidAmount;
		printTotal();
	}
	/*
	 * Prints the total income to console.
	 */
	public void printTotal() {
		System.out.println("**********Revenue Observer**********");
		System.out.println("Total income: " + total);
		System.out.println("************************************");
	}

}
