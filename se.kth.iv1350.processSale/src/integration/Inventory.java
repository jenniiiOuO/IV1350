package integration;
import java.util.ArrayList;
import java.util.List;

import model.RegisteredItemDTO;



public class Inventory
{
	private List<ItemDTO> Inventory = new ArrayList<>();

	Inventory()
	{
		addItem();
	}

	private void addItem()
	{
		Inventory.add(new ItemDTO("kaka", "3678", 25, 0.12));
		Inventory.add(new ItemDTO("yogurt", "1566", 18, 0.12));
		Inventory.add(new ItemDTO("penna", "0054", 10, 0.25));
		Inventory.add(new ItemDTO("tidning", "5997", 30, 0.06));
	}

	public ItemDTO find(String artNr)
	{
		for(ItemDTO item : Inventory)
		{
			if(item.getArticleNumber() == artNr)
				return item;
		}
		return null;
	}

	public void updateInventory(List<RegisteredItemDTO> soldItems)
	{

	}
}
