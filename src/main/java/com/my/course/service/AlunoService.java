package com.my.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.course.model.Aluno;
import com.my.course.repository.Alunos;

@Service
public class AlunoService {

	@Autowired
	private Alunos alunos;
	
	public void salvar(Aluno aluno) {
		alunos.save(aluno);
	}

	public void remover(Long id) {
		alunos.deleteById(id);
	}
	
	public List<Aluno> listaTodos() {
		return alunos.findAll();
	}
	
	public Aluno buscaPorId(long id) {
		return alunos.getOne(id);
	}
	
}
