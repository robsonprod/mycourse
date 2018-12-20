package com.my.course.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.my.course.enuns.StatusEnum;
import com.my.course.model.Aluno;
import com.my.course.service.AlunoService;

@Controller
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;
	
	private static final String CAD_VIEW = "alunos/cadastro";

	@GetMapping
	public ModelAndView listar() {
		List<Aluno> todosAlunos = alunoService.listaTodos();
		ModelAndView mv = new ModelAndView("alunos/listar");
		mv.addObject("alunos", todosAlunos);
		return mv;
	}
	
	@RequestMapping("/cadastrar")
	public ModelAndView cadastro() {
		ModelAndView mv = new ModelAndView(CAD_VIEW);
		mv.addObject(new Aluno());
		
		return mv;
	}
	
	@PostMapping
	public String salvar(@Valid Aluno aluno, Errors errors, RedirectAttributes attr) {
		
		String msg = "Aluno cadastrado com sucesso!";
		String redirect = "redirect:/alunos/cadastrar";
		
		if(errors.hasErrors()) {
			return CAD_VIEW;
		}
		
		if (!Objects.isNull(aluno.getId())) {
			msg = "Aluno atualizado com sucesso!";
			redirect = "redirect:/alunos";
		}
		
		alunoService.salvar(aluno);
		
		attr.addFlashAttribute("msg", msg);
	
		return redirect;
	}
	
	@GetMapping("/{id}")
	public ModelAndView edicao(@PathVariable Long id) {
		
		ModelAndView mv = new ModelAndView(CAD_VIEW);

		mv.addObject(alunoService.buscaPorId(id));
		
		return mv;
	}
	
	@DeleteMapping("/{id}")
	public String excluir(@PathVariable Long id, RedirectAttributes attr) {
		alunoService.remover(id);
		
		attr.addFlashAttribute("msg", "Aluno excluido com sucesso!");
		
		return "redirect:/alunos";
	}
	
	@GetMapping("/exibir/{id}")
	public ModelAndView exibir(@PathVariable Long id) {
		Aluno aluno = alunoService.buscaPorId(id);
		ModelAndView mv = new ModelAndView("/alunos/exibir");
		mv.addObject("aluno", aluno);
		return mv;
	}
	
	@ModelAttribute("todosStatus")
	public List<StatusEnum> todosStatus(){
		return Arrays.asList(StatusEnum.values());
	}

	
}
