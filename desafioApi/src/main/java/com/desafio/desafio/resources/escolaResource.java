package com.desafio.desafio.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.desafio.entities.escola;
import com.desafio.desafio.service.escolaService;

@RestController
@RequestMapping(value = "/escolas")
public class escolaResource {

	@Autowired
	private escolaService service;

	@GetMapping
	public ResponseEntity<List<escola>> findAll() {
		List<escola> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
