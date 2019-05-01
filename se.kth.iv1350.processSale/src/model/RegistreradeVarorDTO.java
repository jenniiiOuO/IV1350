package model;

/**
 * Innehåller all information om en specifik registrerade vara
 *
 */
public class RegistreradeVarorDTO 
{
	private String namn;
	private String artikelnummer;
	private double pris;
	private double momssats;
	private int antal;
	
	/**
	 * Skapar en instans som ska föreställa en registrerad vara
	 * @param namn - namnet på det registrerade vara
	 * @param pris - priset på det registrerade vara (exkluderar moms) 
	 * @param momssats - momssatsen på det regisrerade vara
	 * @param antal - antalet på det regisrerade vara
	 */
	public RegistreradeVarorDTO(String namn, String artikelnummer,double pris, double momssats, int antal)
	{
		this.namn = namn;
		this.artikelnummer = artikelnummer;
		this.pris = pris;
		this.momssats = momssats;
		this.antal = antal;
	}

	/**
	 * Hämtar värdet av namnet på det registrerade varan
	 * @return namnet på det registrerade varan
	 */
	public String getNamn()
	{
		return this.namn;
	}
	/**
	 * Hämtar värdet av artikelnummret på det registrerade varan
	 * @return artikelnummret på det registrerade varan
	 */
	public String getArtikelnummer()
	{
		return this.artikelnummer;
	}
	/**
	 * Hämtar värdet av priset på det registrerade varan
	 * @return priset på det registrerade varan
	 */
	public double getPris()
	{
		return this.pris;
	}
	/**
	 * Hämtar värdet av momsstatsen på det registrerade varan
	 * @return momssatsen på det registrerade varan
	 */
	public double getMomssats()
	{
		return this.momssats;
	}
	/**
	 * Hämtar värdet av antalet på det registrerade varan
	 * @return antalet på det registrerade varan
	 */
	public int getAntal()
	{
		return this.antal;
	}

	/**
	 * Ändrar på antalet på det registrerade varan
	 * @param antal - det nya antalet
	 */
	public void setAntal(int antal)
	{
		this.antal = antal;
	}
	
	/**
	 * Skriver om det registrerade vara till en string med specifik information, 
	 * kommer att användas när ett kvitto ska bildas
	 */
	public String toString()
	{
		return this.namn + "\t" + this.pris + "\t" + this.antal + "\n";
	}
}
