package com.algtech.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algtech.course.entities.User;
import com.algtech.course.repositories.UserRepository;
import com.algtech.course.services.exceptions.DataBaseException;
import com.algtech.course.services.exceptions.ResourceNotFoundException;
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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	//Insere no DB um novo objeto do tipo User
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	//Deleta o usuário pelo id
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
		
	}
	
	public User update(Long id, User obj) {
		User entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		//Atualizar os dados do objeto entity com base no objeto obj
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
