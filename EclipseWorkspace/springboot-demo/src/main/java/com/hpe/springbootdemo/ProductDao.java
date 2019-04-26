package com.hpe.springbootdemo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends CrudRepository<Product, Integer>{
	
	// custom function example for a Customer entity with 'city' property
	// public List<Customer> findByCity(String city);
	public List<Product> findByDiscontinued(Integer val);
	
	@Query("from Product where unitPrice between ?1 and ?2")
	public List<Product> getProductsByPriceRange(Double min, Double max);
}
