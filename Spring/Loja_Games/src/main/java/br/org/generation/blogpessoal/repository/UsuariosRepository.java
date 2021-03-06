package br.org.generation.blogpessoal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.blogpessoal.model.Usuarios;


@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

	public List<Usuarios> findAllBynomeContainingIgnoreCase(String nome);

	public Optional<Usuarios> findByUsuario(String usuario);

}
