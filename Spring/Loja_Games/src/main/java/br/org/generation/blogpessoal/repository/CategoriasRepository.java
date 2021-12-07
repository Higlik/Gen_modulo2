package br.org.generation.blogpessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.blogpessoal.model.Categorias;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias, Long> {

	public List<Categorias> findAllByTipoContainingIgnoreCase(String tipo);
}
