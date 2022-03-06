package com.conatus.conatussb.entities.reports;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TotalizerPerMonth implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer mes;
	private Integer ano;
	private Integer atendimentos;
	private Double total;
	
	public TotalizerPerMonth () {
		super();
	}

			
	public TotalizerPerMonth(Integer mes, Integer ano, Integer atendimentos, Double total) {
		super();
		this.mes = mes;
		this.ano = ano;
		this.atendimentos = atendimentos;
		this.total = total;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getAtendimentos() {
		return atendimentos;
	}

	public void setAtendimentos(Integer atendimentos) {
		this.atendimentos = atendimentos;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ano == null) ? 0 : ano.hashCode());
		result = prime * result + ((atendimentos == null) ? 0 : atendimentos.hashCode());
		result = prime * result + ((mes == null) ? 0 : mes.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
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
		TotalizerPerMonth other = (TotalizerPerMonth) obj;
		if (ano == null) {
			if (other.ano != null)
				return false;
		} else if (!ano.equals(other.ano))
			return false;
		if (atendimentos == null) {
			if (other.atendimentos != null)
				return false;
		} else if (!atendimentos.equals(other.atendimentos))
			return false;
		if (mes == null) {
			if (other.mes != null)
				return false;
		} else if (!mes.equals(other.mes))
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		return true;
	}
	
	
}
