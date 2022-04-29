package com.andre.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andre.model.ItemVO;

@Repository
public interface IItem extends JpaRepository<ItemVO, Integer>{
	
}
