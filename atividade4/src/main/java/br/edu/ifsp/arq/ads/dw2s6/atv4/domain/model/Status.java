package br.edu.ifsp.arq.ads.dw2s6.atv4.domain.model;

public enum Status {

	EMAPROVACAO("Em aprovação"),
	APROVADA("aprovada"),
	EMANDAMENTO("Em andamento"),
	FINALIZADO("Finalizado");
	
	private String description;
	
	private Status(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
}