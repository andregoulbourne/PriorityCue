package com.andre.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import com.andre.model.ItemVO;
import com.andre.repo.IItem;

class ItemServiceTest {
	
	private ItemService service = new ItemService();
	private IItem dao;
	
	@BeforeEach
	void setup() {
		dao = Mockito.mock(IItem.class);
	}
	
	@Test
	void testGetAllSummary(){
		List<ItemVO> rs = new ArrayList<>();
		Mockito.when(dao.findAll()).thenReturn(rs);
		ReflectionTestUtils.setField(service,"dao", dao); 
		
		assertEquals(rs,service.getAll());
	}
	
	private static final ItemVO o = new ItemVO();
	
	@Test
	void testSave() {
		
		ReflectionTestUtils.setField(service,"dao", dao);
		
		assertTrue(service.save(o));
		
		Mockito.when(dao.save(o)).thenReturn(o);
		ReflectionTestUtils.setField(service,"dao", dao); 
		
		assertTrue(service.save(o));
	}
	
	@Test
	void testDeleteSummary() {
		ReflectionTestUtils.setField(service,"dao", dao); 
		
		assertTrue(service.delete(o));
	}
	
}
