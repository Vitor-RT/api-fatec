package br.com.api.fatec.apifatec.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.fatec.apifatec.domain.pedido.PedidoVendaRepository;
import br.com.api.fatec.apifatec.entities.PedidoVenda;

@RestController
@RequestMapping("/api/pedido-venda/v3")
public class PedidoVendaControllerV3 {
    //public = variaveis acessiveis por qualquer um
    //private = variaveis acessiveis somente via metodo get e set
    //protected = variaveis acessiveis por outras classes que foram extendidas da original
    
    @Autowired
    private PedidoVendaRepository repository;

    @PostMapping
    public PedidoVenda criarPedido(@RequestBody PedidoVenda pedido) {
        PedidoVenda pedidoVendaCriar = new PedidoVenda();
        pedidoVendaCriar.setEmissao(pedido.getEmissao());
        pedidoVendaCriar.setTotal(pedido.getTotal());
        pedidoVendaCriar.setStatus(pedido.getStatus());
        pedido.getItems().forEach(Item -> {
            pedidoVendaCriar.addItem(Item);
        });
        // Esta linha é redundante, pois os itens já foram adicionados no forEach acima
        // pedidoVendaCriar.setItems(pedido.getItems());

        PedidoVenda pedidoCriado = repository.save(pedidoVendaCriar);

        return pedidoCriado;
    }
}
