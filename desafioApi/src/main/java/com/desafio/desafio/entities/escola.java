package com.desafio.desafio.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class escola implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)	
private Long id;
	
@OneToMany(mappedBy = "escola")
private List <aluno> alunos ;

public escola() {
	
}


public escola(Long id) {
	super();
	this.id = id;
	
}


public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public List<aluno> getAlunos() {
	return alunos;
}

public void addalunos(aluno a){
    if (alunos.size() <= 100){
        this.alunos.add(a);
    }
    else {
        throw new IllegalArgumentException("Quantidade de alunos foi atingido.");
    }
}


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((alunos == null) ? 0 : alunos.hashCode());
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
	escola other = (escola) obj;
	if (alunos == null) {
		if (other.alunos != null)
			return false;
	} else if (!alunos.equals(other.alunos))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}

public String getAlunosAprovados() {
String str ="";
	
	for (aluno x: alunos) {
		if (x.getMedia()>=7) {
		str=x.getNome() + "  ";
		}
	}
	return str;
}
	
	

}
