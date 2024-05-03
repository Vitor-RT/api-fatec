package br.com.api.fatec.apifatec.domain.pedido.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.api.fatec.apifatec.shared.enums.PedidoVendaStatusEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class PedidoVendaDTO {
    private long id;
    private long cliente_id;
    private LocalDate emissao;
    private BigDecimal total;
    @Enumerated(EnumType.STRING)
    private PedidoVendaStatusEnum status;
    private List<PedidoVendaItemDTO> items = new ArrayList<>();
}
