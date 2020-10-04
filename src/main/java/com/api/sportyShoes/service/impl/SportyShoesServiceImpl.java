package com.api.sportyShoes.service.impl;

import java.sql.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.sportyShoes.exceptionHandler.BusinessException;
import com.api.sportyShoes.model.PurchaseReport;
import com.api.sportyShoes.model.Shoe;
import com.api.sportyShoes.repository.PurchaseReportRepository;
import com.api.sportyShoes.repository.ShoesRepository;
import com.api.sportyShoes.service.SportyShoesService;

@Service
public class SportyShoesServiceImpl implements SportyShoesService{
	
	@Autowired
	private ShoesRepository shoesRepo;
	private PurchaseReportRepository prRepo;

	public Shoe createShoe(Shoe shoe) {
		return shoesRepo.save(shoe);
	}

	public Shoe getShoeById(int id) throws BusinessException {
		Shoe shoe = null;
		try {
			if(id<=0) throw new BusinessException("Shoe Id can not be negative or zero");
			shoe = shoesRepo.findById(id).get();
		}catch(NoSuchElementException e) {
			throw new BusinessException("Shoe not found with Id: "+id);
		}
		return shoe;
	}

	public void deleteShoeById(int id) throws BusinessException {
		shoesRepo.deleteById(id);
	}

	public List<Shoe> getAllShoes() {
		// TODO Auto-generated method stub
		return null;
	}

	public PurchaseReport createPurchaseReport(PurchaseReport pr) {
		// TODO Auto-generated method stub
		return null;
	}

	public PurchaseReport getPurchaseReportById(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PurchaseReport> getAllPurchaseReports() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PurchaseReport> getAllPurchaseReportsByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PurchaseReport> getAllPurchaseReportsByDOP(Date dop) {
		// TODO Auto-generated method stub
		return null;
	}

}
