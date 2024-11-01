package br.edu.ifsp.arq.ads.dw2s6.atv4.domain.model;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "servico")
public class OrdemServico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(max = 120)
	private String descricao;
	@NotNull
	@Column(name = "data_emissao")
	@JsonFormat(pattern =  "dd/MM/yyyy")
	private LocalDate data_emissao;
	@NotNull
	@Column(name = "data_finalizacao")
	@JsonFormat(pattern =  "dd/MM/yyyy")
	private LocalDate data_finalizacao;
	@NotNull
	private Double valor;
	@NotNull
	@Enumerated(EnumType.STRING)
	private Status status;
	@Size(max = 120)
	private String observacoes;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "pagamento_id")
	private FormaPagamento pagamento;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDate getData_emissao() {
		return data_emissao;
	}
	public void setData_emissao(LocalDate data_emissao) {
		this.data_emissao = data_emissao;
	}
	public LocalDate getData_finalizacao() {
		return data_finalizacao;
	}
	public void setData_finalizacao(LocalDate data_finalizacao) {
		this.data_finalizacao = data_finalizacao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getObservacao() {
		return observacoes;
	}
	public void setObservacao(String observacao) {
		this.observacoes = observacao;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public FormaPagamento getPagamento() {
		return pagamento;
	}
	public void setPagamento(FormaPagamento pagamento) {
		this.pagamento = pagamento;
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
		OrdemServico other = (OrdemServico) obj;
		return Objects.equals(id, other.id);
	}
}
