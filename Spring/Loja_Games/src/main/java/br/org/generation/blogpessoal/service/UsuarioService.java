package br.org.generation.blogpessoal.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.org.generation.blogpessoal.model.Usuarios;
import br.org.generation.blogpessoal.repository.UsuariosRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuariosRepository usuariosRepository;
	
	public Optional<Usuarios> cadastrarUsuario(Usuarios usuario) {
		
		if(usuariosRepository.findByUsuario(usuario.getUsuario()).isPresent())
			Optional.empty();
		
		if(calcularIdade(usuario.getDataNascimento()) < 18)
	
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário é menor de 18 anos",null);
		usuario.setSenha(criptografarSenha(usuario.getSenha()));
		
		return Optional.of(usuariosRepository.save(usuario));
	}
	
	
	
public Optional<Usuarios> atualizarUsuario(Usuarios usuario) {
	if (usuariosRepository.findById(usuario.getId()).isPresent()) {
		
		Optional<Usuarios> buscaUsuario = usuariosRepository.findByUsuario(usuario.getUsuario());
		
		if( buscaUsuario.isPresent() ){

			if(buscaUsuario.get().getId() != usuario.getId())
				throw new ResponseStatusException(
					HttpStatus.BAD_REQUEST, "O Usuário já existe!", null);
		}

		if(calcularIdade(usuario.getDataNascimento()) < 18)
		throw new ResponseStatusException(
				HttpStatus.BAD_REQUEST, "O Usuário é menor de idade!", null);

		usuario.setSenha(criptografarSenha(usuario.getSenha()));

		return Optional.of(usuariosRepository.save(usuario));
	} 
		
	return Optional.empty();
}	
	
	
	private int calcularIdade(LocalDate dataNascimento) {
		return Period.between(dataNascimento, LocalDate.now()).getYears();
	}

	private String criptografarSenha(String senha) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		return encoder.encode(senha);
	}
	
}
