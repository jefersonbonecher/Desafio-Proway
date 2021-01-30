package com.desafio.desafio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.desafio.entities.aluno;
import com.desafio.desafio.repositories.alunoRepository;

@Service
public class alunoService {

	@Autowired
	private alunoRepository repository;
	
	public List<aluno> findAll(){
		return repository.findAll();
	}
}
