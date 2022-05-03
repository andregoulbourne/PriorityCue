package com.andre.model;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class ItemDTOTest {
    
    @Test
	void testItem_canSetAndGetData() {
		int id=1 ;
		String name="Name";
		String priority="LOW";
		String date="date";
		String summary="summary";
		double price = 2.00;
		boolean wave = false;
		
		ItemDTO item = new ItemDTO();
		item.setId(id);
		item.setName(name);
		item.setPriority(priority);
		item.setDate(date);
		item.setSummary(summary);
		item.setPrice(price);
		item.setWave(wave);
		
		boolean equivalent = price == item.getPrice();
		
		assertEquals(id,item.getId());
		assertEquals(name,item.getName());
		assertEquals(priority, item.getPriority());
		assertEquals(summary, item.getSummary());
		assertEquals(date, item.getDate());
		assertEquals(true,equivalent);
		assertEquals(wave,item.isWave());
	}
}
