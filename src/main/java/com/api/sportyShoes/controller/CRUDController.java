package com.api.sportyShoes.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.sportyShoes.exceptionHandler.BusinessException;
import com.api.sportyShoes.model.PurchaseReport;
import com.api.sportyShoes.model.Shoe;
import com.api.sportyShoes.service.SportyShoesService;

@RestController
public class CRUDController {

	@Autowired
	private SportyShoesService service;
	
	private MultiValueMap<String, String> errorMap;
	
	@PostMapping("/admin/shoe")
	public ResponseEntity<Shoe> createShoe(@RequestBody Shoe shoe) {
		try {
			return new ResponseEntity<>(service.createShoe(shoe),HttpStatus.OK);
		} catch (BusinessException e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", e.getMessage());
			return new ResponseEntity<>(null, errorMap,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/admin/shoe/{id}")
	public ResponseEntity<Shoe> getShoeById(@PathVariable int id){
		try {
			return new ResponseEntity<>(service.getShoeById(id), HttpStatus.OK);
		}catch(BusinessException e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", e.getMessage());
			return new ResponseEntity<>(null, errorMap,HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/admin/shoe/{id}")
	public ResponseEntity<String> deleteShoeById(@PathVariable int id) {
		try {
			service.deleteShoeById(id);
			return new ResponseEntity<>("Succesfully deleted show with id: "+id,HttpStatus.OK);
		}catch(BusinessException e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", e.getMessage());
			return new ResponseEntity<>(e.getMessage(), errorMap,HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@GetMapping("/admin/shoe/all")
	public ResponseEntity<List<Shoe>> getAllShoes(){
		return new ResponseEntity<List<Shoe>>(service.getAllShoes(), HttpStatus.OK);
	}
	
	@PostMapping("/admin/purchaseReport")
	public ResponseEntity<PurchaseReport> createPurchaseReport(@RequestBody PurchaseReport pr) {
		try {
			return new ResponseEntity<>(service.createPurchaseReport(pr),HttpStatus.OK);
		} catch (BusinessException e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", e.getMessage());
			return new ResponseEntity<>(null, errorMap,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/admin/purchaseReport/id/{id}")
	public ResponseEntity<PurchaseReport> getPurchaseReportById(@PathVariable int id){
		try {
			return new ResponseEntity<>(service.getPurchaseReportById(id), HttpStatus.OK);
		}catch(BusinessException e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", e.getMessage());
			return new ResponseEntity<>(null, errorMap,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/admin/purchaseReport/category/{category}")
	public ResponseEntity<List<PurchaseReport>> getAllPurchaseReportsByCategory(@PathVariable String category){
		return new ResponseEntity<List<PurchaseReport>>(service.getAllPurchaseReportsByCategory(category), HttpStatus.OK);
	}
	
	@GetMapping("/admin/purchaseReport/date/{dateInMs}")
	public ResponseEntity<List<PurchaseReport>> getAllPurchaseReportsByDop(@PathVariable Long dateInMs){
		Date dop = new Date(dateInMs);
		return new ResponseEntity<List<PurchaseReport>>(service.getAllPurchaseReportsByDOP(dop), HttpStatus.OK);
	}
	
	@GetMapping("/admin/purchaseReport/all")
	public ResponseEntity<List<PurchaseReport>> getAllPurchaseReport(){
		return new ResponseEntity<List<PurchaseReport>>(service.getAllPurchaseReports(), HttpStatus.OK);
	}
}
