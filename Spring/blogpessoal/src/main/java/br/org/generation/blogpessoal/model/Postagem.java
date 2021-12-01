package br.org.generation.blogpessoal.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

//Está dizendo para essa classe criar uma tabela no banco
@Entity // == create table
@Table(name = "tb_postagens") // == tabela name
public class Postagem {
	
	// chave id
	@Id // == primary key (id)
	@GeneratedValue(strategy = GenerationType.IDENTITY) // == auto_increment
	private Long id;
	
	@NotBlank(message = "O atributo título é obrigatório") // == não pode ser nulo
	@Size(min = 5, max = 100, message = "O atributo título deve conter no minimo 5 e no máximo 100 caracteres") // == total de caracteres 
	private String titulo;
	
	@NotNull(message = "O atributo texto é obrigatório") // == não pode ser nulo
	@Size(min = 10, max = 1000, message = "O atributo texto deve conter no minimo 10 e no máximo 1000 caracteres") // == total de caracteres
	private String texto;
	
	
	// para trabalhar com as datas
	@UpdateTimestamp
	private LocalDate data;

	// get and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	
	
}
