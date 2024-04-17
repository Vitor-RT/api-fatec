package br.com.api.fatec.apifatec.entities;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido_venda")
public class Pedido_venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @Column(name = "emissao", nullable = false)
    private LocalDate emissao;

    @Column(precision = 20, scale = 2, nullable = false)
    private BigDecimal total;

    @Enumerated(EnumType.STRING, nullable = false)
    private PedidoVendaStatusEnum status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedidoVenda", orphanRemoval = true)
    private List<PedidoVendaItem> items = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getEmissao() {
        return emissao;
    }

    public void setEmissao(LocalDate emissao) {
        this.emissao = emissao;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public PedidoVendaStatusEnum getStatus() {
        return status;
    }

    public void setStatus(PedidoVendaStatusEnum status) {
        this.status = status;
    }

    public List<PedidoVendaItem> getItems() {
        return items;
    }

    public void addItem(PedidoVendaItem item) {
        this.items.add(item);
        item.setPedidoVenda(this);
    }
}
