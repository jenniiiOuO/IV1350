package integration;
import java.util.ArrayList;
import java.util.List;

import model.RegistreradeVarorDTO;

/**
 * Inneh�ller all medtod som kommer att kalla data om varor som s�ljs i snabbk�psbutiken.
 */
public class Lagerkatalog 
{
	private static List<VarorDTO> Lagerkatalog = new ArrayList<>();
	
	Lagerkatalog()
	{
		addVaror();
	}
	/**
	 * Ska f�rest�lla vad som finns i butikens lager
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
	 * @param s�ldaVaror - varor som har blivit s�lda
	 */
	public static void uppdateraLager(List<RegistreradeVarorDTO> s�ldaVaror)
	{
		
	}
}
