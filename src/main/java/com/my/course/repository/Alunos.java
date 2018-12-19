package com.my.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my.course.model.Aluno;

public interface Alunos extends JpaRepository<Aluno, Long>{

}
