package br.com.api.fatec.apifatec.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.fatec.apifatec.entities.PedidoVenda;

@RestController()
@RequestMapping("/api/pedido-venda/v3")
public class PedidoVendaControllerV3 {
    //public = variaveis acessiveis por qualquer um
    //private = variaveis acessiveis somente via metodo get e set
    //protected = variaveis acessiveis por outras classes que foram extendidas da original

    @PostMapping
    public PedidoVenda criarPedido(@RequestBody PedidoVenda pedido){
        System.out.println("teste");
        return null;
    }
}
