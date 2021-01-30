package com.desafio.desafio.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
