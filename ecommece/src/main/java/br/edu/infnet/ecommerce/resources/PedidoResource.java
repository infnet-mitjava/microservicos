package br.edu.infnet.ecommerce.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static Logger log = LoggerFactory.getLogger(PedidoResource.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${cliente.endpoint.url}")
	private String clienteApiUrl;
	
	@Autowired
	private ProdutoClient produtoClient;
	
	@PostMapping
	public PedidoResponseDTO efetuaPedido(@RequestBody PedidoDTO pedidoDTO) {
		log.info("solicitacao para pedido com a inoformacao: {}", pedidoDTO);
		
		if(log.isDebugEnabled()) {
			log.debug("Debug ligado");
		}
		ClienteDTO clienteDTO = restTemplate.getForObject(clienteApiUrl+
					pedidoDTO.getClienteId(), ClienteDTO.class);
		log.info("Chamada a api de clientes realizada: {}", clienteDTO);
		
		ResponseEntity<List<ProdutoCatalogoDTO>> produtos = produtoClient.getProdutos();
		
		return new PedidoResponseDTO(clienteDTO, produtos.getBody());
		
	}

}
