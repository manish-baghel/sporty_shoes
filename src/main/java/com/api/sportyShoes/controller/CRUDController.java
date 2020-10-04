package com.api.sportyShoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.sportyShoes.exceptionHandler.BusinessException;
import com.api.sportyShoes.model.Shoe;
import com.api.sportyShoes.service.SportyShoesService;

@RestController
public class CRUDController {
	@Autowired
	private SportyShoesService service;
	
	private MultiValueMap<String, String> errorMap;
	
	@PostMapping("/shoe")
	public Shoe createShoe(@RequestBody Shoe shoe) {
		return service.createShoe(shoe);
	}
	
	@GetMapping("/shoe/{id}")
	public ResponseEntity<Shoe> getShoeById(@PathVariable int id){
		try {
			return new ResponseEntity<>(service.getShoeById(id), HttpStatus.OK);
		}catch(BusinessException e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", e.getMessage());
			return new ResponseEntity<>(null, errorMap,HttpStatus.NOT_FOUND);
		}
	}
}
