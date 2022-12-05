package br.edu.infnet.ecommerce.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.edu.infnet.ecommerce.clients.ProdutoClient;
import br.edu.infnet.ecommerce.resources.dto.ClienteDTO;
import br.edu.infnet.ecommerce.resources.dto.PedidoDTO;
import br.edu.infnet.ecommerce.resources.dto.PedidoResponseDTO;
import br.edu.infnet.ecommerce.resources.dto.ProdutoCatalogoDTO;

@RestController
@RequestMapping("/pedidos")
public class PedidoResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${cliente.endpoint.url}")
	private String clienteApiUrl;
	
	@Autowired
	private ProdutoClient produtoClient;
	
	@PostMapping
	public PedidoResponseDTO efetuaPedido(@RequestBody PedidoDTO pedidoDTO) {
		
		ClienteDTO clienteDTO = restTemplate.getForObject(clienteApiUrl+
					pedidoDTO.getClienteId(), ClienteDTO.class);
		System.out.println(clienteDTO);
		System.out.println(pedidoDTO);
		
		ResponseEntity<List<ProdutoCatalogoDTO>> produtos = produtoClient.getProdutos();
		System.out.println("foi " + produtos.getBody());
		
		return new PedidoResponseDTO(clienteDTO, produtos.getBody());
		
	}

}
