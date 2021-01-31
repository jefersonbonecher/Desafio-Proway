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

import com.desafio.desafio.entities.questao;
import com.desafio.desafio.service.questaoService;

@RestController
@RequestMapping(value = "/questoes")
public class questaoResource {
	
	@Autowired
	private questaoService service; 
	
		@GetMapping
	public ResponseEntity<List<questao>> findAll() {
		List<questao> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
		
		@GetMapping(value = "{/id}")
	public ResponseEntity<questao> findById(@PathVariable Long id){
		questao obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		}
	
	@PostMapping
	public ResponseEntity<questao> insert(@RequestBody questao obj){
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
	public ResponseEntity<questao> update (@PathVariable Long id, @RequestBody questao obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
	
	
	
