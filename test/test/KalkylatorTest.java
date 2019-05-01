package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import model.Kalkylator;
import model.RegistreradeVarorDTO;

public class KalkylatorTest {

	@Test
	public void testBer�knaTotalPris() {
		List<RegistreradeVarorDTO> lista = new ArrayList<>();
		lista.add(new RegistreradeVarorDTO("kaka", "3678", 25, 0.12, 1));
		lista.add(new RegistreradeVarorDTO("kaka", "3678", 25, 0.12, 1));
		lista.add(new RegistreradeVarorDTO("penna", "0054", 10, 0.25, 1));
		
		double f�rv�ntat = 68.5;
		double resultat = Kalkylator.ber�knaTotalPris(lista);
		assertEquals("v�rdena �r inte lika", f�rv�ntat, resultat);	
	}

	@Test
	public void testBer�knaTotalMoms() {
		List<RegistreradeVarorDTO> lista = new ArrayList<>();
		lista.add(new RegistreradeVarorDTO("kaka", "3678", 25, 0.12, 1));
		lista.add(new RegistreradeVarorDTO("kaka", "3678", 25, 0.12, 1));
		lista.add(new RegistreradeVarorDTO("penna", "0054", 10, 0.25, 1));
		
		double f�rv�ntat = 8.5;
		double resultat = Kalkylator.ber�knaTotalMoms(lista);
		assertEquals("v�rdena �r inte lika", f�rv�ntat, resultat);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testBer�knaDifferens() {
		double summaAvPengar = 100.0;
		double attBetala = 50.0;
		double f�rv�ntat = 50.0;
		double resultat = Kalkylator.ber�knaDifferens(summaAvPengar, attBetala);
		assertEquals("v�rdena �r inte lika", f�rv�ntat, resultat);
	}

}
