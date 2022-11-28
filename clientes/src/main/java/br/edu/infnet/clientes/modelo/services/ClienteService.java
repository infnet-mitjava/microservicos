package br.edu.infnet.clientes.modelo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.clientes.modelo.entidades.Cliente;
import br.edu.infnet.clientes.modelo.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente getByCodigo(Long codigo) {
		return clienteRepository.findById(codigo).get();
	}

	
}
