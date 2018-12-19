package com.my.course.enuns;

public enum StatusEnum {

	MATRICULADO("Matriculado"),
	TRANCADO("Trancado"),
	JUBILADO("Jubilado");
	
	private String descricao;
	
	StatusEnum(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
