package com.api.sportyShoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	/**
	 * Shoe post request controller
	 * 
	 * @param shoe
	 * @return ResponseEntity<Shoe> with newly created Shoe
	 */
	@PostMapping("/admin/shoe")
	public ResponseEntity<Shoe> createShoe(@RequestBody Shoe shoe) {
		try {
			return new ResponseEntity<>(service.createShoe(shoe), HttpStatus.OK);
		} catch (BusinessException e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", e.getMessage());
			return new ResponseEntity<>(null, errorMap, HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Shoe get request controller
	 * 
	 * @param id
	 * @return ResponseEntity<Shoe> with the given id
	 */
	@GetMapping("/admin/shoe/{id}")
	public ResponseEntity<Shoe> getShoeById(@PathVariable int id) {
		try {
			return new ResponseEntity<>(service.getShoeById(id), HttpStatus.OK);
		} catch (BusinessException e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", e.getMessage());
			return new ResponseEntity<>(null, errorMap, HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Shoe put(update) request controller
	 * 
	 * @param shoe
	 * @return ResponseEntity<Shoe> with updated shoe
	 */
	@PutMapping("/admin/shoe")
	public ResponseEntity<Shoe> updateShoe(@RequestBody Shoe shoe) {
		return new ResponseEntity<>(service.updateShoe(shoe), HttpStatus.OK);
	}

	/**
	 * Shoe delete request controller
	 * 
	 * @param id
	 * @return ResponseEntity<String> containing the status of delete operation
	 */
	@DeleteMapping("/admin/shoe/{id}")
	public ResponseEntity<String> deleteShoeById(@PathVariable int id) {
		try {
			service.deleteShoeById(id);
			return new ResponseEntity<>("Succesfully deleted shoe with id: " + id, HttpStatus.OK);
		} catch (BusinessException e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", e.getMessage());
			return new ResponseEntity<>(e.getMessage(), errorMap, HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Purchase Report post request controller
	 * 
	 * @param pr - Purchase Report
	 * @return ResponseEntity<PurchaseReport> with newly created Purchase Report
	 */
	@PostMapping("/admin/purchaseReport")
	public ResponseEntity<PurchaseReport> createPurchaseReport(@RequestBody PurchaseReport pr) {
		try {
			return new ResponseEntity<>(service.createPurchaseReport(pr), HttpStatus.OK);
		} catch (BusinessException e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", e.getMessage());
			return new ResponseEntity<>(null, errorMap, HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Purchase Report get request controller
	 * 
	 * @param id
	 * @return ResponseEntity<PurchaseReport> with given id
	 */
	@GetMapping("/admin/purchaseReport/id/{id}")
	public ResponseEntity<PurchaseReport> getPurchaseReportById(@PathVariable int id) {
		try {
			return new ResponseEntity<>(service.getPurchaseReportById(id), HttpStatus.OK);
		} catch (BusinessException e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", e.getMessage());
			return new ResponseEntity<>(null, errorMap, HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Purchase Report put(update) request controller
	 * 
	 * @param pr
	 * @return ResponseEntity<PurchaseReport> containing updated Purchase Report
	 */
	@PutMapping("/admin/purchaseReport")
	public ResponseEntity<PurchaseReport> updatePurchaseReport(@RequestBody PurchaseReport pr) {
		return new ResponseEntity<>(service.updatePurchaseReport(pr), HttpStatus.OK);
	}

	/**
	 * Purchase Report delete request controller
	 * 
	 * @param id
	 * @return ResponseEntity<String> containing the status of delete request.
	 */
	@DeleteMapping("/admin/purchaseReport/{id}")
	public ResponseEntity<String> deletePurchaseReportById(@PathVariable int id) {
		try {
			service.deletePurchaseReportById(id);
			return new ResponseEntity<>("Succesfully deleted Purchase Report with id: " + id, HttpStatus.OK);
		} catch (BusinessException e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", e.getMessage());
			return new ResponseEntity<>(e.getMessage(), errorMap, HttpStatus.BAD_REQUEST);
		}
	}
}
