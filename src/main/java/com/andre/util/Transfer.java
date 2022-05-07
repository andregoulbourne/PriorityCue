package com.andre.util;

import com.andre.model.ItemDTO;
import com.andre.model.ItemVO;

public class Transfer {
	
	public static ItemVO transfer(ItemDTO item) {
		ItemVO rs = new ItemVO();
		rs.setId(item.getId());
		rs.setName(item.getName());
		rs.setPriority(item.getPriority());
		rs.setSummary(item.getSummary());
		rs.setPrice(item.getPrice());
		rs.setWave(item.isWave());
		rs.setDate(item.getDate());
		return rs;
	}

}
