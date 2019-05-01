package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import model.Kalkylator;
import model.RegistreradeVarorDTO;

public class KalkylatorTest {

	@Test
	public void testBeräknaTotalPris() {
		List<RegistreradeVarorDTO> lista = new ArrayList<>();
		lista.add(new RegistreradeVarorDTO("kaka", "3678", 25, 0.12, 1));
		lista.add(new RegistreradeVarorDTO("kaka", "3678", 25, 0.12, 1));
		lista.add(new RegistreradeVarorDTO("penna", "0054", 10, 0.25, 1));
		
		double förväntat = 68.5;
		double resultat = Kalkylator.beräknaTotalPris(lista);
		assertEquals("värdena är inte lika", förväntat, resultat);	
	}

	@Test
	public void testBeräknaTotalMoms() {
		List<RegistreradeVarorDTO> lista = new ArrayList<>();
		lista.add(new RegistreradeVarorDTO("kaka", "3678", 25, 0.12, 1));
		lista.add(new RegistreradeVarorDTO("kaka", "3678", 25, 0.12, 1));
		lista.add(new RegistreradeVarorDTO("penna", "0054", 10, 0.25, 1));
		
		double förväntat = 8.5;
		double resultat = Kalkylator.beräknaTotalMoms(lista);
		assertEquals("värdena är inte lika", förväntat, resultat);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testBeräknaDifferens() {
		double summaAvPengar = 100.0;
		double attBetala = 50.0;
		double förväntat = 50.0;
		double resultat = Kalkylator.beräknaDifferens(summaAvPengar, attBetala);
		assertEquals("värdena är inte lika", förväntat, resultat);
	}

}
