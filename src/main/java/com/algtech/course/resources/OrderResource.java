package com.algtech.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algtech.course.entities.Order;
import com.algtech.course.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

	@Autowired
	private OrderService service;//Dependência para a classe de serviço de Order
	
	//Endpoint para acessar os usuários
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//A requisição aceita um {id} dentro da url
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
