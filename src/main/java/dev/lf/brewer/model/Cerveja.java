package dev.lf.brewer.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Cerveja {

	@NotBlank(message = "preencha o SKU")
	private String sku;

	@NotBlank(message = "preencha o nome")
	private String nome;

	@Size(max = 100, min = 10, message = "Descrição deve ter no mínimo 10 e no máximo 100 caracteres")
	private String descricao;

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
