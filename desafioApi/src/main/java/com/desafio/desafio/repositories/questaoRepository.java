package com.desafio.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.desafio.entities.questao;


public interface questaoRepository extends JpaRepository<questao, Long> {

}
