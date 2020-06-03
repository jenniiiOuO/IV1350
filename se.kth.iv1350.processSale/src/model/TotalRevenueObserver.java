package model;

/**
 * 
 * Interface for the revenue observer
 *
 */
public interface TotalRevenueObserver {

	/*
	 * Calculates and shows the total income since the program start.
	 */
	void newTotalIncome(double paidAmount);
}
