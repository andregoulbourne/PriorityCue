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
		boolean rs = false;
		ItemVO persisted = dao.save(item);
		if(persisted!=null) rs = true;
		return rs;
	}
	
	public boolean delete(ItemVO item) {
		boolean rs = false;
		dao.delete(item);
		Optional<ItemVO> persisted = dao.findById(item.getId());
		if(persisted==null) rs = true;
		return rs;
	}
	
	
}
