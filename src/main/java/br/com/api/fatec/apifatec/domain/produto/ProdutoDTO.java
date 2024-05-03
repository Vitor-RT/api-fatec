package br.com.api.fatec.apifatec.domain.produto;

import java.math.BigDecimal;

public class ProdutoDTO {
    private Long id;
    private String descricao;
    private BigDecimal preco;
    private Integer quantidade_estoque;
    private Boolean ativo;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public Integer getEstoque() {
		return quantidade_estoque;
	}
	public void setEstoque(Integer quantidade_estoque) {
		this.quantidade_estoque = quantidade_estoque;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
}