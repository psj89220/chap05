package com.example.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.repository.EmpRepository;

import lombok.extern.java.Log;

@Controller
@RequestMapping("/emp")
@Log
public class EmpController {
	
	@Inject
	EmpRepository empRepository;
	
	@GetMapping("/list")
	public String list() {
		log.info("/emp/list 호출됨");
		
		empRepository.findAll().forEach(e -> {
			System.out.println(e);
		});
		
		return "jsp/emp/list";
	}

}
