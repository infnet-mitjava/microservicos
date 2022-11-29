package br.edu.infnet.catalogo.modelo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.catalogo.modelo.entidades.Produto;
import br.edu.infnet.catalogo.modelo.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> getAll(){
		return (List<Produto>) produtoRepository.findAll(); 
	}
	
	
}
