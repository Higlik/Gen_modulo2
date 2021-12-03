package br.org.generation.blogpessoal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_temas2")
public class Tema {
	
	// Gera o ID da tb_temas2
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	// Atributo descrição
	@NotBlank(message = "O atributo descrição não pode ser vazio")
	private String descricao;
	
	//puxa todas as list associadas ao 'tema'
	@OneToMany(mappedBy = "tema", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("tema")
	private List<Postagem> postagem;

	
	//----------------------------------------------------------------
		// GET AND SET
	//-----------------------------------------------------------------
		
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}
	
	
	
	
	
}
