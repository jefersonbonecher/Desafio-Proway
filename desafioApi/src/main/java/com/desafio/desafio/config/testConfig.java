package com.desafio.desafio.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.desafio.desafio.entities.prova;
import com.desafio.desafio.entities.questao;
import com.desafio.desafio.repositories.provaRepository;
import com.desafio.desafio.repositories.questaoRepository;

@Configuration
@Profile("test")
public class testConfig implements CommandLineRunner {
	
	@Autowired
	private questaoRepository questaoRepository;
	
	@Autowired
	private provaRepository provaRepository;

	@Override
	public void run(String... args) throws Exception {
		
		prova p1 = new prova (null, "A B");
		prova p2 = new prova (null, "C D");
		
		provaRepository.saveAll(Arrays.asList(p1,p2));
		
		questao q1 = new questao(null,2, "A",p1);
		questao q2 = new questao(null,1,"c", p2);
		
		questaoRepository.saveAll(Arrays.asList(q1,q2));
	}

}
