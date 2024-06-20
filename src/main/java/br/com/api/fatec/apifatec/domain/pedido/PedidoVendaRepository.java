package br.com.api.fatec.apifatec.domain.pedido;

import br.com.api.fatec.apifatec.entities.PedidoVenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.List;

public interface PedidoVendaRepository extends JpaRepository<PedidoVenda, Long>, JpaSpecificationExecutor<PedidoVenda> {
    List<PedidoVenda> findByClienteId(Long clienteId);
}