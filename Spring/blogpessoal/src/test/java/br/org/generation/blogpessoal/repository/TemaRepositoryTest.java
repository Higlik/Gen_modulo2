package br.org.generation.blogpessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import br.org.generation.blogpessoal.model.Tema;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TemaRepositoryTest {

	@Autowired
	private TemaRepository temaRepository;
	
	@BeforeAll
	void start( ) {
		
		temaRepository.save(new Tema(0l, "Teste JUnit"));
		temaRepository.save(new Tema (0l, "Teste Springboot"));
		temaRepository.save(new Tema(0l, "Teste JAVA"));
		temaRepository.save(new Tema (0l, "Teste MySQL"));
		
	}
	
	@Test
	@DisplayName("retora um tema 👌")
	public void deveRetornarUmUsuario() {
		
		Optional<Tema> tema = temaRepository.findByDescricao("Teste JUnit");
		assertTrue(tema.get().getDescricao().equals("teste JUnit"));
		
	}
	
	@Test
	@DisplayName("🤷‍♂️🤷‍♂️🤷‍♂️ Retorna 3 temas")
	public void deveRetornarTresTemas() {
		
		List<Tema> listaDeTemas = temaRepository.findAllByDescricaoContainingIgnoreCase("Teste");
		assertEquals(3, listaDeTemas.size());
		assertTrue(listaDeTemas.get(0).getDescricao().equals("Teste JAVA"));
		assertTrue(listaDeTemas.get(1).getDescricao().equals("Teste JUnit"));
		assertTrue(listaDeTemas.get(2).getDescricao().equals("Teste MySQL"));
		
		
	}
	
	
}
