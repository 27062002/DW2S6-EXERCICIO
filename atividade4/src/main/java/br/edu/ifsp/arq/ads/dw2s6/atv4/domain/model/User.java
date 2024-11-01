package br.edu.ifsp.arq.ads.dw2s6.atv4.domain.model;

import java.util.List;
import java.util.Objects;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
	private String telefone;
	@NotNull
	private String password;
	@NotNull
	@CPF
	private String cpf;
	@NotNull
	private Boolean active;
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
	@ManyToMany(fetch = FetchType.EAGER) // fetch = buscar - eager = ancioso
	@JoinTable(name = "user_permission", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "id_permission"))
	private List<Permission> permissions;
	
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
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
