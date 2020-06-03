package model;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import integration.ItemDTO;

import org.junit.*;
import static org.junit.Assert.assertEquals;

class SaleTest {

	
	@Test
	void CalculatePrice() {
		List<RegisteredItemDTO> list = new ArrayList<>();
		list.add(new RegisteredItemDTO("kaka", "3678", 25, 0.12, 1));
		list.add(new RegisteredItemDTO("kaka", "3678", 25, 0.12, 1));
		list.add(new RegisteredItemDTO("penna", "0054", 10, 0.25, 1));

		Sale sale = new Sale();
		sale.setListWithRegisteredItems(list);
		double expectedValue = 68.5;
		double result = sale.calculatePrice();

		assertEquals("the values are not the same", expectedValue, result, 0.001);
	}

	@Test
	void CalculateVat() {
		List<RegisteredItemDTO> list = new ArrayList<>();
		list.add(new RegisteredItemDTO("kaka", "3678", 25, 0.12, 1));
		list.add(new RegisteredItemDTO("kaka", "3678", 25, 0.12, 1));
		list.add(new RegisteredItemDTO("penna", "0054", 10, 0.25, 1));

		Sale sale = new Sale();
		sale.setListWithRegisteredItems(list);
		double expectedValue = 8.5;
		double result = sale.calculateVat();

		assertEquals("the values are not the same", expectedValue, result, 0.001);
	}

	@Test
	void calculateDifference() {
		double totalToPay = 80.0;
		double totalPaid = 100.0;
		double expectedValue = 20.0;
		double result = Sale.calculateChange(totalPaid);

		assertEquals("the values are not the same", expectedValue, result, 0.001);
	}

	@Test
	void calculateDifferenceNoChange() {
		double totalToPay = 100.0;
		double totalPaid = 50.0;
		double expectedValue = 0; // no change back
		double result = Sale.calculateChange(totalPaid);

		assertEquals("gives negative change back", expectedValue, result, 0.001);
	}

}
