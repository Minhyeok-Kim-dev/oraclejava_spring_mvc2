package com.oraclejava.mvc2.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.oraclejava.mvc2.dao.PhoneDao;
import com.oraclejava.mvc2.dao.PhoneDaoRepository;
import com.oraclejava.mvc2.model.Phone;

@Controller
@RequestMapping("/phone")
public class PhoneController {
	
//	@Autowired
//	private PhoneDao<Phone> dao;
	
	@Autowired
	private PhoneDaoRepository repository;
	
	@RequestMapping(method=RequestMethod.GET)
	public String index(Map<String, Object> model) {
		//List<Phone> pList = dao.getAllEntity();
		List<Phone> pList = repository.findAll();
		
		for(Phone p : pList) {
			System.out.println(p);
		}
		
		model.put("phoneList", pList);
		
		return "/phone/index";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addPhone(@RequestParam String name,
			@RequestParam int price) {
		
		Phone phone = new Phone(name, price);
		
		//dao.addEntity(phone);
		repository.saveAndFlush(phone);
		
		return "redirect:/phone";
	}
	
	
	// Update
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String editPhone(Map<String, Object> model,
			@PathVariable String id) {

		//List<Phone> phoneList = dao.findByField("id", id);
		//Phone phone = phoneList.get(0);
		Phone phone = repository.findOne(Integer.parseInt(id));
		
		if(phone == null)
			return "redirect:/phone";
		
		model.put("phone", phone);
		
		return "/phone/detail";
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public String editPhone(Map<String, Object> model,
			Phone phone,
			@PathVariable String id) {
		
		//dao.updateEntity(phone);
		repository.saveAndFlush(phone);
		
		return "redirect:/phone";
	}
	
	
	// Delete
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String deletePhone(@PathVariable String id) {
		
		//dao.removeEntity(Integer.parseInt(id));
		repository.delete(Integer.parseInt(id));
	
		return "redirect:/phone";
	}
}
