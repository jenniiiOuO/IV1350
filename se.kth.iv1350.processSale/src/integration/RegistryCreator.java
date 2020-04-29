package integration;


public class RegistryCreator
{
	private Inventory inven = new Inventory();
	private MemberSystem memsys = new MemberSystem();
	private DiscountSystem dissys = new DiscountSystem();

	public Inventory getInventory()
	{
		return inven;
	}

	public MemberSystem getMemberSystem()
	{
		return memsys;
	}

	public DiscountSystem getDiscountSystem()
	{
		return dissys;
	}
}
