package br.edu.infnet.catalogo.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.catalogo.modelo.entidades.Produto;
import br.edu.infnet.catalogo.modelo.services.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {

	private static Logger log = LoggerFactory.getLogger(ProdutoResource.class);
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public ResponseEntity<List<Produto>> getProdutos(){
		log.info("API de Produto");

		try {
			throw new RuntimeException("Erro de negocio");
		} catch (Exception e) {
			log.error("Erro forçado", e);
		}
		
		return ResponseEntity.ok(produtoService.getAll());
	}
	
}
