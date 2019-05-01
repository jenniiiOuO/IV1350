package integration;

/**
 *Innehåller all information om en specifik vara.
 */
public class VarorDTO 
{
	private final String namn;
	private final String artikelnummer;
	private final double pris;
	private final double momssats;
	
	/**
	 * Metoden skapar en ny instans som ska representera en vara
	 * @param namn - namnet på varan
	 * @param artikelnummer - artikelnummer på varan
	 * @param pris - priset på varan inkluderar moms
	 * @param momssats - säger andel av priset som är moms, i faktor
	 */
	public VarorDTO(String namn, String artikelnummer, double pris, double momssats)
	{
		this.namn = namn;
		this.artikelnummer = artikelnummer;
		this.pris = pris;
		this.momssats = momssats;
	}
	
	/**
	 * Hämtar värdet av namnet på varan
	 * @return värdet av namnet på varan
	 */
	public String getNamn()
	{
		return this.namn;
	}
	/**
	 * Hämtar värdet av artikelnummer på varan
	 * @return värdet av artikelnummer på varan
	 */
	public String getArtikelnummer()
	{
		return this.artikelnummer;
	}
	/**
	 * Hämtar värdet av priset på varan
	 * @return värdet av priset på varan
	 */
	public double getPris()
	{
		return this.pris;
	}
	/**
	 * Hämtar värdet av momssatsen på varan
	 * @return värdet av momssatsen på varan
	 */
	public double getMomssats()
	{
		return this.momssats;
	}
	
	/**
	 * Undersöker om varan matchar med det sökta artikelnummret
	 * @param registreradeArtikelnummret - det sökta artikelnummret
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
