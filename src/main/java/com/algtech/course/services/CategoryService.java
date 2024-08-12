package com.algtech.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algtech.course.entities.Category;
import com.algtech.course.repositories.CategoryRepository;
//Registra a classe como um serviço Spring - permite as injeções de dependência automáticas
@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	//Retorna todos os usuários do DB
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
}
