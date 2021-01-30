package com.desafio.desafio.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.desafio.entities.prova;
import com.desafio.desafio.service.provaService;

@RestController
@RequestMapping(value = "/provas")
public class provaResource {

	@Autowired
	private provaService service;

	@GetMapping
	public ResponseEntity<List<prova>> findAll() {
		List<prova> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
