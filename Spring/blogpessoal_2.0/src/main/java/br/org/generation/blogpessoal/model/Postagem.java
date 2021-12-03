package br.org.generation.blogpessoal.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_postagens2")
public class Postagem {

	
	// Gera o Id da tabela
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	// Atributo título da tb
	@NotBlank(message = "O atributo título não pode ser vazio")
	@Size(min = 5, max = 100, message = "O atributo título deve conter de 5 a 100 carcteres")
	private String titulo;
	
	// Atributo texto da tb
	@NotBlank(message = "O atributo texto não pode ser vazio")
	@Size(min = 10, max = 1000, message = "O atributo texto deve conter de 10 a 1000 carcteres")
	private String texto;
	
	//Mostra o tempo real da maquina
	@UpdateTimestamp
	private LocalDate data;
	
	//FK da tb
	@ManyToOne
	@JsonIgnoreProperties
	private Tema tema;
	
	//----------------------------------------------------------------
		// GET AND SET
	//-----------------------------------------------------------------
		

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}
	

	
	
}
