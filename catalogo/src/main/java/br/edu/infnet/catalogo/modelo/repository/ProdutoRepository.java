package br.edu.infnet.catalogo.modelo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.catalogo.modelo.entidades.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long>{

}
