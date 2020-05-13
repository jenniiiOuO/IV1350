package integration;
import java.util.ArrayList;
import java.util.List;

import model.RegisteredItemDTO;



public class Inventory
{
	private List<ItemDTO> Inventory = new ArrayList<>();

	public Inventory()
	{
		Inventory.add(new ItemDTO("kaka", "3678", 25, 0.12));
		Inventory.add(new ItemDTO("yogurt", "1566", 18, 0.12));
		Inventory.add(new ItemDTO("penna", "0054", 10, 0.25));
		Inventory.add(new ItemDTO("tidning", "5997", 30, 0.06));
	}

	public void addItem(ItemDTO item)
	{
		Inventory.add(item);
	}
	
	/*
	 * find the item with the same article number
	 * @param artNr - the article number of the searched item
	 * @return item - the item that has the same article number as the parameter
	 * @throws DoesNotExistException if there is no item with such artNr.
	 */
	public ItemDTO find(String artNr) throws DoesNotExistException, InventoryException
	{
		ItemDTO searchedItem = new ItemDTO("","", 0, 0);
		for(ItemDTO item : Inventory)
		{
			if(item.getArticleNumber() == artNr)
				searchedItem = item;
		}
		
		searchedItem.setArticleNumber("ERROR");
		
		if(searchedItem.getArticleNumber() == "") {
			searchedItem = null;
		}
		
		if(searchedItem == null) {
			throw new DoesNotExistException(artNr);
		}
		
		if(searchedItem.getArticleNumber() == "ERROR") {
			throw new InventoryException("Something went wrong, try again");
		}
		return searchedItem;

	}
	
	/*
	 * updates items in the inventory
	 */
	public void updateInventory(List<RegisteredItemDTO> soldItems)
	{

	}
}
