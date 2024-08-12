package com.algtech.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algtech.course.entities.Product;
import com.algtech.course.repositories.ProductRepository;
//Registra a classe como um serviço Spring - permite as injeções de dependência automáticas
@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	//Retorna todos os usuários do DB
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
}
