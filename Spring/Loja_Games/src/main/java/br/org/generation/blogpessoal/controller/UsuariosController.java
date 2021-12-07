package br.org.generation.blogpessoal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.blogpessoal.model.Usuarios;
import br.org.generation.blogpessoal.repository.UsuariosRepository;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuariosController {

	@Autowired
	private UsuariosRepository usuariosRepository;
	
	@GetMapping
	public ResponseEntity<List<Usuarios>> getAll() {
		return ResponseEntity.ok(usuariosRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuarios> getById(@PathVariable long id) {
		return usuariosRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Usuarios>> getByNome(@PathVariable String nome) {
		return ResponseEntity.ok(usuariosRepository.findAllBynomeContainingIgnoreCase(nome));
	}
	
	/*@GetMapping("/data_nascimento/{data_nascimento}")
	public ResponseEntity<List<Usuarios>> getByData_Nascimento(@PathVariable Instat data_nascimento) {
		return ResponseEntity.ok(usuariosRepository.findAllBynomeContainingIgnoreCase(data_nascimento));
	}*/
	
	@PostMapping
	public ResponseEntity<Usuarios> postUsuarios(@Valid @RequestBody Usuarios usuarios) {
		return ResponseEntity.status(HttpStatus.CREATED).body(usuariosRepository.save(usuarios));
	}
			
	@PutMapping
	public ResponseEntity<Usuarios> putUsuarios(@Valid @RequestBody Usuarios usuarios) {
		return usuariosRepository.findById(usuarios.getId())
		.map(resposta -> ResponseEntity.ok().body(usuariosRepository.save(usuarios)))
		.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUsuarios(@PathVariable long id) {
		return usuariosRepository.findById(id).map(resposta -> {
				usuariosRepository.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}).orElse(ResponseEntity.notFound().build());
	}
	
}
