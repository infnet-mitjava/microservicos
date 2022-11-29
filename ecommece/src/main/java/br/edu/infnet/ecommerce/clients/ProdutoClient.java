package br.edu.infnet.ecommerce.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.infnet.ecommerce.resources.dto.ProdutoCatalogoDTO;

@FeignClient("produto")
public interface ProdutoClient {

    @RequestMapping("/produtos")
    ResponseEntity<List<ProdutoCatalogoDTO>> getProdutos();
    
}
