package com.algtech.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algtech.course.entities.Order;
import com.algtech.course.repositories.OrderRepository;
//Registra a classe como um serviço Spring - permite as injeções de dependência automáticas
@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	//Retorna todos os usuários do DB
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}
