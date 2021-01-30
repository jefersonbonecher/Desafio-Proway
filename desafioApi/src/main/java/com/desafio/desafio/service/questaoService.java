package com.desafio.desafio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.desafio.entities.questao;
import com.desafio.desafio.repositories.questaoRepository;

@Service
public class questaoService {

	@Autowired
	private questaoRepository repository;
	
	public List<questao> findAll(){
		return repository.findAll();
	}
}
