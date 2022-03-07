package com.conatus.conatussb.entities.reports;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProofOfOrder {
	@Id
	private Integer cod_produto;
	private String descricao;
	private Integer qt_produto_vendido;
	private Double vl_unitario_produto_vendido;
	
	public ProofOfOrder() {
		super();
	}
	
	public ProofOfOrder(Integer cod_produto, String descricao, Integer qt_produto_vendido,
			Double vl_unitario_produto_vendido) {
		super();
		this.cod_produto = cod_produto;
		this.descricao = descricao;
		this.qt_produto_vendido = qt_produto_vendido;
		this.vl_unitario_produto_vendido = vl_unitario_produto_vendido;
	}
	
	public Integer getCod_produto() {
		return cod_produto;
	}
	public void setCod_produto(Integer cod_produto) {
		this.cod_produto = cod_produto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getQt_produto_vendido() {
		return qt_produto_vendido;
	}
	public void setQt_produto_vendido(Integer qt_produto_vendido) {
		this.qt_produto_vendido = qt_produto_vendido;
	}
	public Double getVl_unitario_produto_vendido() {
		return vl_unitario_produto_vendido;
	}
	public void setVl_unitario_produto_vendido(Double vl_unitario_produto_vendido) {
		this.vl_unitario_produto_vendido = vl_unitario_produto_vendido;
	}
	
	public Double getsubTotal() {
		return vl_unitario_produto_vendido*qt_produto_vendido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod_produto == null) ? 0 : cod_produto.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((qt_produto_vendido == null) ? 0 : qt_produto_vendido.hashCode());
		result = prime * result + ((vl_unitario_produto_vendido == null) ? 0 : vl_unitario_produto_vendido.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProofOfOrder other = (ProofOfOrder) obj;
		if (cod_produto == null) {
			if (other.cod_produto != null)
				return false;
		} else if (!cod_produto.equals(other.cod_produto))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (qt_produto_vendido == null) {
			if (other.qt_produto_vendido != null)
				return false;
		} else if (!qt_produto_vendido.equals(other.qt_produto_vendido))
			return false;
		if (vl_unitario_produto_vendido == null) {
			if (other.vl_unitario_produto_vendido != null)
				return false;
		} else if (!vl_unitario_produto_vendido.equals(other.vl_unitario_produto_vendido))
			return false;
		return true;
	}
	
}
