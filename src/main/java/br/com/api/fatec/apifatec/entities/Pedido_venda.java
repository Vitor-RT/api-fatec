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

    @Column(nullable = false)
    private Date emissao;

    @Column(nullable = false)
    private Double total;

    @Column(nullable = false)
    private Integer cliente_id;

    @Column(nullable = false)
    private String status;
}
