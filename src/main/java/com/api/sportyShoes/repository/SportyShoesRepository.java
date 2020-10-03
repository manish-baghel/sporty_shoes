package com.api.sportyShoes.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.sportyShoes.model.PurchaseReport;

@Repository
public interface SportyShoesRepository extends JpaRepository<PurchaseReport, Integer>{
	
	public List<PurchaseReport> findByCategory(String category);
	public List<PurchaseReport> findByDate(Date dop);
}
