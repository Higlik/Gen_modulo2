package br.org.generation.blogpessoal.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

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
	@Size(min = 2, max = 15, message = "O nome de usuário deve conter de 2 a 15 caracteres")
	private String senha;
	
	//Atributo foto
	private String foto;
	
	//Data
	private int data_nascimento;
	
	//Cadastra o tempo real da maquina
		@UpdateTimestamp
		private LocalDate data;
	
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

	public int getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(int data_nascimento) {
		this.data_nascimento = data_nascimento;
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

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public List<Produtos> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produtos> produtos) {
		this.produtos = produtos;
	}
	
	
	

}
