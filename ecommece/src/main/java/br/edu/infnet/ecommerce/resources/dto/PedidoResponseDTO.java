package br.edu.infnet.ecommerce.resources.dto;

import java.util.List;

public class PedidoResponseDTO {
	
	private ClienteDTO cliente;
	
	private List<ProdutoCatalogoDTO> listaProdCatDTO;
	
	public PedidoResponseDTO() {
	}
	public PedidoResponseDTO(ClienteDTO cliente, List<ProdutoCatalogoDTO> listaProdCatDTO) {
		super();
		this.cliente = cliente;
		this.listaProdCatDTO = listaProdCatDTO;
	}

	
	public ClienteDTO getCliente() {
		return cliente;
	}

	public List<ProdutoCatalogoDTO> getListaProdCatDTO() {
		return listaProdCatDTO;
	}

	
	

}
