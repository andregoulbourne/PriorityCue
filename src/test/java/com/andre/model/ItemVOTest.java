package com.andre.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.Test;



class ItemVOTest {

	@Test
	void testItem_canSetAndGetData() {
		int id=1 ;
		String name="Name";
		Priority priority=Priority.LOW;
		String date="date";
		String summary="summary";
		double price = 2.00;
		boolean wave = false;
		
		ItemVO item = new ItemVO();
		item.setId(id);
		item.setName(name);
		item.setPriority(priority);
		item.setDate(date);
		item.setSummary(summary);
		item.setPrice(price);
		item.setWave(wave);
		
		assertEquals(id,item.getId());
		assertEquals(name,item.getName());
		assertEquals(priority, item.getPriority());
		assertEquals(summary, item.getSummary());
		assertEquals(date, item.getDate());
		assertTrue(price==item.getPrice());
		assertFalse(item.isWave());
	}

	

}