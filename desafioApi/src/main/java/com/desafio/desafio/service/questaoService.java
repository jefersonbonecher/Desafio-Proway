package com.desafio.desafio.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.desafio.desafio.entities.questao;
import com.desafio.desafio.repositories.questaoRepository;
import com.desafio.desafio.service.exceptions.DatabaseException;
import com.desafio.desafio.service.exceptions.ResourceNotFoundException;

@Service
public class questaoService {

	@Autowired
	private questaoRepository repository;
	
	public List<questao> findAll(){
		return repository.findAll();
	}
	
	public questao findById(Long id) {
		Optional<questao> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public questao insert (questao obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public questao update(Long id, questao obj) {
		try {
			questao entity = repository.getOne(id);
			update(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}	
	}

	private void update(questao entity, questao obj) {
		entity.setPeso(obj.getPeso());
		entity.setResposta(obj.getResposta());
		
	}
}
