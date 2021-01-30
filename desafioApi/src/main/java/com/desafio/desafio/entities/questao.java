package com.desafio.desafio.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "tb_questao")
public class questao implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int peso;
	private String resposta;
	
	@ManyToOne
	@JoinColumn(name = "prova_id")
	private prova prova;

public questao () {
	
}

public questao(Long id, int peso, String resposta, prova prova) {
	this.id = id;
	this.peso = peso;
	this.resposta = resposta;
	this.prova = prova;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public int getPeso() {
	return peso;
}

public void setPeso(int peso) {
	this.peso = peso;
}


public String getResposta() {
	return resposta;
}

public void setResposta(String resposta) {
	this.resposta = resposta;
}

public prova getProva() {
	return prova;
}

public void setProva(prova prova) {
	this.prova = prova;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	questao other = (questao) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}









}
