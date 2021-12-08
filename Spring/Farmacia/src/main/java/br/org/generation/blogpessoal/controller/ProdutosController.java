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
import br.org.generation.blogpessoal.model.Produtos;
import br.org.generation.blogpessoal.repository.ProdutosRepository;


@RestController
@RequestMapping ("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutosController {

	@Autowired
	private ProdutosRepository produtosRepository;
	
	@GetMapping
	public ResponseEntity<List<Produtos>> getAll() {
		return ResponseEntity.ok(produtosRepository.findAll());
	}
	
	@GetMapping("/nome/laboratorio/{nome}/{laboratorio}")
	public ResponseEntity <List<Produtos>> getNome(@PathVariable String nome,@PathVariable String laboratorio) {
		return ResponseEntity.ok(produtosRepository.findByNomeAndLaboratorioAllIgnoreCase(nome, laboratorio));
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity <Produtos> getById(@PathVariable long id) {
		return produtosRepository.findById(id).
				map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Produtos> postProdutos (@Valid @RequestBody Produtos produtos) {
		return produtosRepository.findById(produtos.getCategoria().getId())
				.map(resp -> ResponseEntity.status(HttpStatus.CREATED).body(produtosRepository.save(produtos)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping
	public ResponseEntity<Produtos> putProdutos (@Valid @RequestBody Produtos produtos) {
		return produtosRepository.findById(produtos.getId())
				.map(resp -> ResponseEntity.status(HttpStatus.CREATED).body(produtosRepository.save(produtos)))
				.orElse(ResponseEntity.notFound().build());					
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProdutos (@PathVariable long id) {
		return produtosRepository.findById(id).map(resp -> {
				produtosRepository.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}).orElse(ResponseEntity.notFound().build());
	}
			
}