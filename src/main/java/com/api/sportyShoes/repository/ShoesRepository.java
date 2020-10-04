package com.api.sportyShoes.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.sportyShoes.model.Shoe;

@Repository
public interface ShoesRepository extends JpaRepository<Shoe, Integer>{
	
}
