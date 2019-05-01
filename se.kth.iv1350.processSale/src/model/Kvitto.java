package model;

import java.time.LocalDateTime;
/**
 * Innehåller all information som behövs för ett kvitto
 */
public class Kvitto 
{
	private Köpinformation köpinformation;
	private double summaAvPengar;
	private double växel;
	private static String datum;
	private static String butiknamn = "Snabbköpsbutik";
	private static String butikadress = "köpgata 1";
	
	/**
	 * skapar en instans
	 * @param köpinformation - en lista av all information om ett köp
	 * @param växel - växel som kunden får tillbaka
	 * @param datum - datum på köpet
	 * @param butiknamn - butikens namn
	 * @param butikadress - butikens adress
	 */
	public Kvitto(Köpinformation köpinformation, double summaAvPengar, double växel, 
			String datum, String butiknamn, String butikadress)
	{
		this.köpinformation = köpinformation;
		this.summaAvPengar = summaAvPengar;
		this.växel = växel;
		this.datum = datum;
	}
	/**
	 * en metod som skapar ett kvitto
	 * @param köpinformation - information om ett köp
	 * @param summaAvPengar - summa av pengar som kunden betalar med
	 * @param växel - växel som kunden får tillbaka
	 * @return ett kvitto
	 */
	public static Kvitto skapaKvitto(Köpinformation köpinformation, double summaAvPengar, double växel)
	{
		LocalDateTime lokaldatum = LocalDateTime.now();
		datum = lokaldatum.toString();
		return new Kvitto(köpinformation, summaAvPengar,växel, datum, butiknamn, butikadress);
		
	}
	/**
	 * Skriver om kvittot till en String
	 */
	public String toString()
	{
		return "Kvitto" + "\n" + this.butiknamn + "\n" + this.butikadress + "\n" + köpinformation + 
				"\n" + "Betald: " + this.summaAvPengar + "\n" + "Växel: " + this.växel + "\n";
	}
}
