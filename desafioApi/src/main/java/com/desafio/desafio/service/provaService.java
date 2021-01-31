package com.desafio.desafio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.desafio.entities.prova;
import com.desafio.desafio.repositories.provaRepository;

@Service
public class provaService {

	@Autowired
	private provaRepository repository;
	
	public List<prova> findAll(){
		return repository.findAll();
	}
	public prova findById(Long id) {
		Optional<prova> obj = repository.findById(id);
		return obj.get();
	}
}
