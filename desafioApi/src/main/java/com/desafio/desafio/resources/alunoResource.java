package com.desafio.desafio.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	@GetMapping(value = "{/id}")
	public ResponseEntity<aluno> findById(@PathVariable Long id){
		aluno obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		}
	
	@PostMapping
	public ResponseEntity<aluno> insert(@RequestBody aluno obj){
		obj= service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "{/id}")
	public ResponseEntity<Void> delete (@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
		}
	
	@PutMapping
	public ResponseEntity<aluno> update (@PathVariable Long id, @RequestBody aluno obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
