package br.edu.ifsp.arq.ads.dw2s6.spring_ioc.model;

import java.time.LocalDate;

public class Cartao {
	private Long numero;
	private String nomeCliente;
	private LocalDate validade;

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public LocalDate getValidade() {
		return validade;
	}

	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}

}
