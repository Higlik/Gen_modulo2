package br.org.generation.blogpessoal.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tb_produtos")
public class Produtos {

	// Gera ID 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	// Nome do produto
	@Size(min = 5, max = 30, message = "O nome deve conter de 5 a 30 caracteres")
	private String nome;
	
	
	//Descrição do produto
	@Size(min = 5, max= 500, message = "A desção do produto deve conter de 5 a 500 caracteres")
	private String descricao;
	
	//Console para o game
	@Size(max= 500, message = "O console deve conter 2 a 25 caracteres")
	private String console;
	
	//Quantidade do produto
	private int quantidade;
	
	//Valor do produto
	private int valor;
	
	//foto
	@NotBlank(message = "O produto necessita ter uma imagem")
	private String foto;
	
	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private Categorias categorias;
	
	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private Usuarios usuarios;

	
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getConsole() {
		return console;
	}

	public void setConsole(String console) {
		this.console = console;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Categorias getCategorias() {
		return categorias;
	}

	public void setCategirias(Categorias categorias) {
		this.categorias = categorias;
	}

	public Usuarios getUsuario() {
		return usuarios;
	}

	public void setUsuario(List<Usuarios> usuario) {
		this.usuarios = usuarios;
	}
	
	
	
	
	
		
	
	
}
