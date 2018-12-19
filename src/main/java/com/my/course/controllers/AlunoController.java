package com.my.course.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.my.course.enuns.StatusEnum;
import com.my.course.model.Aluno;
import com.my.course.service.AlunoService;

@Controller
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;

	@GetMapping
	public ModelAndView listar() {
		List<Aluno> todosAlunos = alunoService.listaTodos();
		ModelAndView mv = new ModelAndView("/alunos/listar");
		mv.addObject("alunos", todosAlunos);
		return mv;
	}
	
	@RequestMapping("/cadastrar")
	public ModelAndView cadastro() {
		ModelAndView mv = new ModelAndView("alunos/cadastro");
		mv.addObject("Status", StatusEnum.values());
		
		return mv;
	}
	
	@PostMapping
	public String salvar(Aluno aluno) {
		
		System.out.println(aluno);
		
		alunoService.salvar(aluno);


		return "/alunos";
	}

	
}
