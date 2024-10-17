package br.edu.ifsp.arq.ads.dw2s6.atv4.domain.model;

import java.time.LocalDate;
import java.util.Objects;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min = 3, max = 50)
	private String name;
	@NotNull
	@Email
	private String email;
	@NotNull
	@CPF
	private String cpf;
	@Embedded
	@AttributeOverrides({
		  @AttributeOverride( name = "logradouro", column = @Column(name = "logradouro")),
		  @AttributeOverride( name = "numero", column = @Column(name = "numero")),
		  @AttributeOverride( name = "complemento", column = @Column(name = "complemento")),
		  @AttributeOverride( name = "bairro", column = @Column(name = "bairro")),
		  @AttributeOverride( name = "cidade", column = @Column(name = "cidade")),
		  @AttributeOverride( name = "estado", column = @Column(name = "estado")),
		  @AttributeOverride( name = "cep", column = @Column(name = "cep"))
		})
	private Adress adress;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
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
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
}
