package com.andre.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.andre.model.ItemDTO;
import com.andre.service.ItemService;
import com.andre.util.ObjectToDTO;

@Controller
@RequestMapping("items")
public class ItemController {

	@Autowired
	private ItemService service;
	
	private Map<String,Object> respMap;
	
	
	//Constants
	private static final String SUCCESS = "SUCCESS";
	
	private static final String ERROR = "ERROR";
	
	private static final String DATA ="data";
	
	private static final String MSG = "msg";
	
	private static final String STATUS= "status";
	
	
	@GetMapping
	public @ResponseBody Map<String, Object> getAllItems(){
		respMap = new HashMap<>();
		respMap.put(DATA,service.getAll());
		respMap.put(MSG, SUCCESS);
		return respMap;
		
	}
	
	@PostMapping
	public @ResponseBody Map<String, Object> saveItem(@RequestBody ItemDTO item){
		respMap = new HashMap<>();
		boolean status = service.save(ObjectToDTO.convert(item));
		return handleStatus(status);
	}
	
	@DeleteMapping
	public @ResponseBody Map<String, Object> deleteAItem(@RequestBody ItemDTO item){
		respMap = new HashMap<>();
		boolean status = service.delete(ObjectToDTO.convert(item));
		return handleStatus(status);
	}
		
	// helper method handles boolean status returns a result map
	private @ResponseBody Map<String, Object> handleStatus(boolean status){
		respMap.put(STATUS,status);
		if(status) {
			respMap.put(MSG, SUCCESS);
		} else {
			respMap.put(MSG, ERROR);
		}
		return respMap;
	}
	
}
