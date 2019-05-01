package integration;
import java.util.ArrayList;
import java.util.List;

import model.RegistreradeVarorDTO;

/**
 * Innehåller all medtod som kommer att kalla data om varor som säljs i snabbköpsbutiken.
 */
public class Lagerkatalog 
{
	private static List<VarorDTO> Lagerkatalog = new ArrayList<>();
	
	Lagerkatalog()
	{
		addVaror();
	}
	/**
	 * Ska föreställa vad som finns i butikens lager
	 */
	private void addVaror()
	{
		Lagerkatalog.add(new VarorDTO("kaka", "3678", 25, 0.12));
		Lagerkatalog.add(new VarorDTO("yogurt", "1566", 18, 0.12));
		Lagerkatalog.add(new VarorDTO("penna", "0054", 10, 0.25));
		Lagerkatalog.add(new VarorDTO("tidning", "5997", 30, 0.06));
	}
	
	/**
	 * Hittar en specifik vara som matchar med artikelnummret
	 * @param registreradeArtikelnumret - artikelnummer som ska hittas
	 * @return varan som har artikelnummret, om inget hittas returneras <code>null<code>
	 */
	public static VarorDTO hitta(String registreradeArtikelnumret)
	{
		for(VarorDTO vara : Lagerkatalog)
		{
			if(vara.matchar(registreradeArtikelnumret))
				return vara;
		}
		return null;
	}
	
	/**
	 * Metoden ska uppdatera lagret i butiken
	 * @param såldaVaror - varor som har blivit sålda
	 */
	public static void uppdateraLager(List<RegistreradeVarorDTO> såldaVaror)
	{
		
	}
}
