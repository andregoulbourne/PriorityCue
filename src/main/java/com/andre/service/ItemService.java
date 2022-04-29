package com.andre.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andre.model.ItemVO;
import com.andre.repo.IItem;

@Service
public class ItemService {
	
	@Autowired
	private IItem dao;
	
	public List<ItemVO> getAll() {
		return dao.findAll();
	}
	
	public boolean save(ItemVO item) {
		boolean rs;
		dao.save(item);
		rs = true;
		return rs;
	}
	
	public boolean delete(ItemVO item) {
		boolean rs = true;
		dao.delete(item);
		Optional<ItemVO> present = dao.findById(item.getId());
		if(present.isPresent()) rs = false;	
		return rs;
	}
	
	
}
