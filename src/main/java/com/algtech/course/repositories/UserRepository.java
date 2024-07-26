package com.algtech.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algtech.course.entities.User;

//Classe responsável pela interação com o banco de dados
//A extensão JpaRepository realiza a implementação das funçoes CRUD automaticamente.
//Não é necessário adicionar o @Repository, pois a classe já herda do JpaRepository
public interface UserRepository extends JpaRepository<User, Long>{

	
}