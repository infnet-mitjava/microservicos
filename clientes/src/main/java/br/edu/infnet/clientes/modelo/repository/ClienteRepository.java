package br.edu.infnet.clientes.modelo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.clientes.modelo.entidades.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>{

}
