package com.desafio.desafio.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.desafio.entities.aluno;
import com.desafio.desafio.service.alunoService;

@RestController
@RequestMapping(value = "/alunos")
public class alunoResource {

	@Autowired
	private alunoService service;

	@GetMapping
	public ResponseEntity<List<aluno>> findAll() {
		List<aluno> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
