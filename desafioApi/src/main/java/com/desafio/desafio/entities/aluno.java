package com.desafio.desafio.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class aluno implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)	
private Long id;
	private String nome; 
	private String resultados;
	private Set<prova> provas = new HashSet<>();
	
	public aluno() {
		
	}



	public aluno(Long id, String nome, String resultados, Set<prova> provas) {
		super();
		this.id = id;
		this.nome = nome;
		this.resultados = resultados;
		this.provas = provas;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getResultados() {
		return resultados;
	}

	public void setResultados(String resultados) {
		this.resultados = resultados;
	}

	public Set<prova> getProvas() {
		return provas;
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
		aluno other = (aluno) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}
