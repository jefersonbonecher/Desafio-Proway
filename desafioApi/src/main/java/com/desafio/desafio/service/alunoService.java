package com.desafio.desafio.service;

import java.util.List;
import java.util.Optional;

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
	public aluno findById(Long id) {
		Optional<aluno> obj = repository.findById(id);
		return obj.get();
	}
	
	public aluno insert (aluno obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public aluno update(Long id, aluno obj) {
		aluno entity = repository.getOne(id);
		update(entity, obj);
		return repository.save(entity);
	}

	private void update(aluno entity, aluno obj) {
		entity.setNome(obj.getNome());
		entity.setResultados(obj.getResultados());
		
	}
}