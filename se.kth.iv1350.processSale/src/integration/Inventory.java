package integration;
import java.util.ArrayList;
import java.util.List;


/**
 * Inneh�ller all medtod som kommer att kalla data om varor som s�ljs i snabbk�psbutiken.
 */
public class Inventory
{
	private static List<ItemDTO> Inventory = new ArrayList<>();

	Inventory()
	{
		addItem();
	}
	/**
	 * Ska f�rest�lla vad som finns i butikens lager
	 */
	private void addItem()
	{
		Inventory.add(new ItemDTO("kaka", "3678", 25, 0.12));
		Inventory.add(new ItemDTO("yogurt", "1566", 18, 0.12));
		Inventory.add(new ItemDTO("penna", "0054", 10, 0.25));
		Inventory.add(new ItemDTO("tidning", "5997", 30, 0.06));
	}

	/**
	 * Hittar en specifik item som matchar med artikelnummret
	 * @param articleNumber - artikelnummer som ska hittas
	 * @return itemn som har artikelnummret, om inget hittas returneras <code>null<code>
	 */
	public static ItemDTO find(String artNr)
	{
		for(ItemDTO item : Inventory)
		{
			if(item.articleNumber == artNr))
				return item;
		}
		return null;
	}

	/**
	 * Metoden ska uppdatera lagret i butiken
	 * @param s�ldaVaror - varor som har blivit s�lda
	 */
	public static void updateInventory(List<listWithRegisteredItems> soldItems)
	{

	}
}
