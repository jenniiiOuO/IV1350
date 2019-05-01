package model;

import java.time.LocalDateTime;
/**
 * Inneh�ller all information som beh�vs f�r ett kvitto
 */
public class Kvitto 
{
	private K�pinformation k�pinformation;
	private double summaAvPengar;
	private double v�xel;
	private static String datum;
	private static String butiknamn = "Snabbk�psbutik";
	private static String butikadress = "k�pgata 1";
	
	/**
	 * skapar en instans
	 * @param k�pinformation - en lista av all information om ett k�p
	 * @param v�xel - v�xel som kunden f�r tillbaka
	 * @param datum - datum p� k�pet
	 * @param butiknamn - butikens namn
	 * @param butikadress - butikens adress
	 */
	public Kvitto(K�pinformation k�pinformation, double summaAvPengar, double v�xel, 
			String datum, String butiknamn, String butikadress)
	{
		this.k�pinformation = k�pinformation;
		this.summaAvPengar = summaAvPengar;
		this.v�xel = v�xel;
		this.datum = datum;
	}
	/**
	 * en metod som skapar ett kvitto
	 * @param k�pinformation - information om ett k�p
	 * @param summaAvPengar - summa av pengar som kunden betalar med
	 * @param v�xel - v�xel som kunden f�r tillbaka
	 * @return ett kvitto
	 */
	public static Kvitto skapaKvitto(K�pinformation k�pinformation, double summaAvPengar, double v�xel)
	{
		LocalDateTime lokaldatum = LocalDateTime.now();
		datum = lokaldatum.toString();
		return new Kvitto(k�pinformation, summaAvPengar,v�xel, datum, butiknamn, butikadress);
		
	}
	/**
	 * Skriver om kvittot till en String
	 */
	public String toString()
	{
		return "Kvitto" + "\n" + this.butiknamn + "\n" + this.butikadress + "\n" + k�pinformation + 
				"\n" + "Betald: " + this.summaAvPengar + "\n" + "V�xel: " + this.v�xel + "\n";
	}
}
