package integration;

/**
 * Denna klass skapar alla register som kommer att anv�ndas i programmet
 *
 */
public class RegistryCreator
{
	private Inventory inven = new Inventory();
	private MemberSystem memsys = new MemberSystem();
	private DiscountSystem dissys = new DiscountSystem();
	/**
	 * H�mtar v�rden av Inventoryen
	 * @return information i Inventory
	 */
	public Inventory getInventory()
	{
		return inven;
	}

	/**
	 * H�mtar v�rden av Inventoryen
	 * @return information i Inventory
	 */
	public MemberSystem getMemberSystem()
	{
		return memsys;
	}

	/**
	 * H�mtar v�rden av Inventoryen
	 * @return information i Inventory
	 */
	public DiscountSystem getDiscountSystem()
	{
		return dissys;
	}
}
