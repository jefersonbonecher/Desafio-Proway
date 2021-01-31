package com.desafio.desafio.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.desafio.desafio.entities.aluno;
import com.desafio.desafio.entities.escola;
import com.desafio.desafio.entities.prova;
import com.desafio.desafio.repositories.alunoRepository;
import com.desafio.desafio.repositories.escolaRepository;
import com.desafio.desafio.repositories.provaRepository;

@Configuration
@Profile("test")
public class testConfig implements CommandLineRunner {
	/*
	@Autowired
	private questaoRepository questaoRepository;
	*/
	@Autowired
	private provaRepository provaRepository;

	@Autowired
	private alunoRepository alunoRepository;
	
	@Autowired
	private escolaRepository escolaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		
		escola es = new escola(null);
		escolaRepository.saveAll(Arrays.asList(es));
		
		
		
		aluno a = new aluno(null,"Jeferson","a",es);
		alunoRepository.saveAll(Arrays.asList(a));
		
		
		prova p1 = new prova (null);
		prova p2 = new prova (null);
		
		provaRepository.saveAll(Arrays.asList(p1,p2));
		/*
		questao q1 = new questao(null,2, "A",p1);
		questao q2 = new questao(null,1,"C",p1);
		questao q3 = new questao(null,3,"D",p1);
		questao q4 = new questao(null,2,"D",p1);
		questao q5 = new questao(null,2,"D",p1);
	
		questaoRepository.saveAll(Arrays.asList(q1,q2,q3,q4,q5));
*/	}
	
}


