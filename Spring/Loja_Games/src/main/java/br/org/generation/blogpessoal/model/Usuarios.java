package br.org.generation.blogpessoal.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_usuarios")
public class Usuarios {
	
	//Gera o ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//Atributo Usuario
	@NotBlank (message = "O nome de usuário não pode ser vazio")
	@Size(min = 2, max = 15, message = "O nome de usuário deve conter de 2 a 15 caracteres")
	private String usuario;
	
	//Atributo Nome
		@NotBlank (message = "O nome de usuário não pode ser vazio")
		@Size(min = 2, max = 15, message = "O nome de usuário deve conter de 2 a 15 caracteres")
		private String nome;
	
	//Atributo senha
	@NotBlank (message = "O nome de usuário não pode ser vazio")
	@Size(min = 8, message = "A senha deve ter no minímo 8 caracteres")
	private String senha;
	
	//Atributo foto
	private String foto;
	
	
	@Column(name = "data_nascimento")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "A data de nascimento não pode ser vazia")
	private LocalDate dataNascimento;
	
	//FK
	@OneToMany (mappedBy = "usuarios", cascade = CascadeType.ALL)
	@JsonIgnoreProperties ("usuarios")
	private List<Produtos> produtos;
	
	//----------------------------------------------------------------
			// GET AND SET
	//-----------------------------------------------------------------
			

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}


	public List<Produtos> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produtos> produtos) {
		this.produtos = produtos;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
	

}
