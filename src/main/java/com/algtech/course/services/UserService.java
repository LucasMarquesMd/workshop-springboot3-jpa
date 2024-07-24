package com.algtech.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algtech.course.entities.User;
import com.algtech.course.repositories.UserRepository;
//Registra a classe como um serviço Spring - permite as injeções de dependência automáticas
@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	//Retorna todos os usuários do DB
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
}
