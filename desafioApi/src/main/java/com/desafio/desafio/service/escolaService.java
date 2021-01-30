package com.desafio.desafio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.desafio.entities.escola;
import com.desafio.desafio.repositories.escolaRepository;

@Service
public class escolaService {

	@Autowired
	private escolaRepository repository;
	
	public List<escola> findAll(){
		return repository.findAll();
	}
}
