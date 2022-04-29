package com.andre.controller;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import com.andre.controllers.ItemController;
import com.andre.model.ItemVO;
import com.andre.service.ItemService;

@SpringBootTest
class ItemControllerTest {

	@Autowired
	private ItemController controller;
	
	private ItemService service;
	
	@BeforeEach
	void init() {
		service = Mockito.mock(ItemService.class);
		ReflectionTestUtils.setField(controller, "service", service);
	}
	
	@Test
	void testGetAllItems() {
		assertDoesNotThrow(() -> controller.getAllItems());
	}
	
	
	private ItemVO item=new ItemVO();
	
	@Test
	void testUpdateAItem() {
		assertDoesNotThrow(() -> controller.saveItem(item));
		assertFalse((boolean) controller.saveItem(item).get("status"));
		
		Mockito.when(service.save(item)).thenReturn(true);
		ReflectionTestUtils.setField(controller, "service", service);
		assertDoesNotThrow(() -> controller.saveItem(item));
		assertTrue((boolean) controller.saveItem(item).get("status"));
	}
	
	@Test
	void testDeleteAItem() {
		assertDoesNotThrow(() -> controller.deleteAItem(item));
		assertFalse((boolean) controller.deleteAItem(item).get("status"));
		
		Mockito.when(service.delete(Mockito.any())).thenReturn(true);
		ReflectionTestUtils.setField(controller, "service", service);
		assertDoesNotThrow(() -> controller.deleteAItem(item));
	}
	
}
