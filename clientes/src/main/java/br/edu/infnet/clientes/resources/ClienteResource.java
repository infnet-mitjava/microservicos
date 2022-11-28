package br.edu.infnet.clientes.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.clientes.modelo.entidades.Cliente;
import br.edu.infnet.clientes.modelo.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/{codigo}")
	public Cliente getCliente(@PathVariable Long codigo) {
		return clienteService.getByCodigo(codigo);
	}
	
	
}
