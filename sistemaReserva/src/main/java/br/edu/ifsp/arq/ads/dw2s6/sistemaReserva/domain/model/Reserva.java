package br.edu.ifsp.arq.ads.dw2s6.sistemaReserva.domain.model;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "reserva")
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "data_inicio")
	@JsonFormat(pattern =  "dd/MM/yyyy")
	private LocalDate data_inicio;
	@Column(name = "data_fim")
	@JsonFormat(pattern =  "dd/MM/yyyy")
	private LocalDate data_fim;
	@Size(min = 3, max = 45)
	private String status;
	private Integer usuario_id;
	@ManyToOne
	@JoinColumn(name = "recurso_id")
	private Recurso recurso;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getData_inicio() {
		return data_inicio;
	}
	public void setData_inicio(LocalDate data_inicio) {
		this.data_inicio = data_inicio;
	}
	public LocalDate getData_fim() {
		return data_fim;
	}
	public void setData_fim(LocalDate data_fim) {
		this.data_fim = data_fim;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getUsuario_id() {
		return usuario_id;
	}
	public void setUsuario_id(Integer usuario_id) {
		this.usuario_id = usuario_id;
	}
	public Recurso getRecurso() {
		return recurso;
	}
	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return Objects.equals(id, other.id);
	}
}
