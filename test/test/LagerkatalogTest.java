package test;

import org.junit.Test;

import integration.Lagerkatalog;
import integration.VarorDTO;
import junit.framework.TestCase;

public class LagerkatalogTest extends TestCase {

	@Test 
	public void testHittaTillg�ngliaVaror() {
		VarorDTO testVara = new VarorDTO("kaka", "3678", 25, 0.12);
		Lagerkatalog lagerkatalog = new Lagerkatalog();
		VarorDTO f�rv�ntat = testVara;
		VarorDTO resultat = Lagerkatalog.hitta(testVara.getArtikelnummer());
		assertEquals("Hittar inte en vara som ska vara tillg�nglig", f�rv�ntat, resultat);
	}
	
	@Test 
	public void testHittaVarorMedOgiltigArtikelnummer() {
		VarorDTO testVara = new VarorDTO("kaka", "0099", 25, 0.12);
		Lagerkatalog lagerkatalog = new Lagerkatalog();
		VarorDTO f�rv�ntat = null;
		VarorDTO resultat = Lagerkatalog.hitta(testVara.getArtikelnummer());
		assertEquals("Hittar en vara med en artikelnummer som inst ska finnas", f�rv�ntat, resultat);
	}
	
	@Test 
	public void testHittaVarorMedAnnatNamn() {
		VarorDTO testVara = new VarorDTO("ananas", "3678", 25, 0.12);
		Lagerkatalog lagerkatalog = new Lagerkatalog();
		VarorDTO f�rv�ntat = null;
		VarorDTO resultat = Lagerkatalog.hitta(testVara.getArtikelnummer());
		assertEquals("Antar att de �r lika", f�rv�ntat, resultat);
	}
	
}
