package integration;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.*;
import static org.junit.Assert.assertEquals;

class InventoryTest {

	@Test
	public void findAvalibleItem() {
		ItemDTO testItem = new ItemDTO("kaka", "3678", 25, 0.12);
		Inventory inven = new Inventory();
		ItemDTO expectedItem = testItem;
		try{
			ItemDTO result = inven.find("3678");
			assertEquals("Can't find the item, different article number", expectedItem.getArticleNumber(), result.getArticleNumber());
			assertEquals("Can't find the item, different name", expectedItem.getName(), result.getName());
			assertEquals("Can't find the item, different price", expectedItem.getPrice(), result.getPrice(), 0.001);
			assertEquals("Can't find the item, different vat rate", expectedItem.getVatRate(), result.getVatRate(), 0.001);
		}catch(DoesNotExistException e){
			fail("unexpected exception" + e.getMessage());
		}catch(InventoryException e) {
			fail("unexpected exception" + e.getMessage());
		}
	}
	
	@Test
	public void findItemWithInvalidArticleNumber() {
		Inventory inven = new Inventory();
		ItemDTO expectedItem = null;
		try{
			ItemDTO result = inven.find("0001");
			fail("should have thrown expection");
		}catch(DoesNotExistException e){

		}catch(InventoryException e){
			
		}
	}

	@Test
	public void findDifferentItemsWithSameArticleNumber() {
		ItemDTO testItem = new ItemDTO("boll", "3678", 25, 0.12);
		Inventory inven = new Inventory();
		inven.addItem(testItem);
		ItemDTO expectedItem = testItem;
		try{
			ItemDTO result = inven.find("3678");
			assertEquals("They are same", expectedItem, result);
		}catch(DoesNotExistException e){
			fail("unexpected exception" + e.getMessage());
		}catch(InventoryException e){
			fail("unexpected exception" + e.getMessage());
		}
	}

}
