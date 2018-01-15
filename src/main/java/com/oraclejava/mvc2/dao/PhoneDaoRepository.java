package com.oraclejava.mvc2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oraclejava.mvc2.model.Phone;

public interface PhoneDaoRepository 
	extends JpaRepository<Phone, Integer> {
	
	List<Phone> findByNameLike(String name);

}
