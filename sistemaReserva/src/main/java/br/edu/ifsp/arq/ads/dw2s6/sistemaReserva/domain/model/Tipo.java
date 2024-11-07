package br.edu.ifsp.arq.ads.dw2s6.sistemaReserva.domain.model;

public enum Tipo {

	SALA("Sala"),
	EQUIPAMENTO("Equipamento"),
	OUTRO("Outro");
	
	private String description;
	
	private Tipo(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}

}

