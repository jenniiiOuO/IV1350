package model;

/**
 * Inneh�ller all information om en specifik registrerade vara
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
	 * Skapar en instans som ska f�rest�lla en registrerad vara
	 * @param namn - namnet p� det registrerade vara
	 * @param pris - priset p� det registrerade vara (exkluderar moms) 
	 * @param momssats - momssatsen p� det regisrerade vara
	 * @param antal - antalet p� det regisrerade vara
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
	 * H�mtar v�rdet av namnet p� det registrerade varan
	 * @return namnet p� det registrerade varan
	 */
	public String getNamn()
	{
		return this.namn;
	}
	/**
	 * H�mtar v�rdet av artikelnummret p� det registrerade varan
	 * @return artikelnummret p� det registrerade varan
	 */
	public String getArtikelnummer()
	{
		return this.artikelnummer;
	}
	/**
	 * H�mtar v�rdet av priset p� det registrerade varan
	 * @return priset p� det registrerade varan
	 */
	public double getPris()
	{
		return this.pris;
	}
	/**
	 * H�mtar v�rdet av momsstatsen p� det registrerade varan
	 * @return momssatsen p� det registrerade varan
	 */
	public double getMomssats()
	{
		return this.momssats;
	}
	/**
	 * H�mtar v�rdet av antalet p� det registrerade varan
	 * @return antalet p� det registrerade varan
	 */
	public int getAntal()
	{
		return this.antal;
	}

	/**
	 * �ndrar p� antalet p� det registrerade varan
	 * @param antal - det nya antalet
	 */
	public void setAntal(int antal)
	{
		this.antal = antal;
	}
	
	/**
	 * Skriver om det registrerade vara till en string med specifik information, 
	 * kommer att anv�ndas n�r ett kvitto ska bildas
	 */
	public String toString()
	{
		return this.namn + "\t" + this.pris + "\t" + this.antal + "\n";
	}
}
