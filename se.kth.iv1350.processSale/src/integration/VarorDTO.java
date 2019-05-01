package integration;

/**
 *Inneh�ller all information om en specifik vara.
 */
public class VarorDTO 
{
	private final String namn;
	private final String artikelnummer;
	private final double pris;
	private final double momssats;
	
	/**
	 * Metoden skapar en ny instans som ska representera en vara
	 * @param namn - namnet p� varan
	 * @param artikelnummer - artikelnummer p� varan
	 * @param pris - priset p� varan inkluderar moms
	 * @param momssats - s�ger andel av priset som �r moms, i faktor
	 */
	public VarorDTO(String namn, String artikelnummer, double pris, double momssats)
	{
		this.namn = namn;
		this.artikelnummer = artikelnummer;
		this.pris = pris;
		this.momssats = momssats;
	}
	
	/**
	 * H�mtar v�rdet av namnet p� varan
	 * @return v�rdet av namnet p� varan
	 */
	public String getNamn()
	{
		return this.namn;
	}
	/**
	 * H�mtar v�rdet av artikelnummer p� varan
	 * @return v�rdet av artikelnummer p� varan
	 */
	public String getArtikelnummer()
	{
		return this.artikelnummer;
	}
	/**
	 * H�mtar v�rdet av priset p� varan
	 * @return v�rdet av priset p� varan
	 */
	public double getPris()
	{
		return this.pris;
	}
	/**
	 * H�mtar v�rdet av momssatsen p� varan
	 * @return v�rdet av momssatsen p� varan
	 */
	public double getMomssats()
	{
		return this.momssats;
	}
	
	/**
	 * Unders�ker om varan matchar med det s�kta artikelnummret
	 * @param registreradeArtikelnummret - det s�kta artikelnummret
	 * @return <code>true<code> om de matchar, <code>false<code> om de inte matchar
	 */
	public boolean matchar(String registreradeArtikelnummret)
	{
		if(this.artikelnummer == registreradeArtikelnummret)
			return true;
		else
			return false;
	}
}
