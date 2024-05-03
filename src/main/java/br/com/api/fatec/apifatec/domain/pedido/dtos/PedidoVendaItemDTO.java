package br.com.api.fatec.apifatec.domain.pedido.dtos;

import java.math.BigDecimal;

public class PedidoVendaItemDTO {
    private Integer id;

    private Long produtoId;

    private Integer quantidade;

    private BigDecimal valorUnitario;
}