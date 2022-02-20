package com.conatus.conatussb.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.conatus.conatussb.entities.Product;


@Repository
public class ProductCustomRepository {
	
	private final EntityManager em;

	public ProductCustomRepository(EntityManager em) {
		super();
		this.em = em;
	}
	
	public List<Product> findCustomAll(Long id, String descricao, String inativo, String limite) {
		
		String query = "SELECT * FROM PRODUTOS as s ";
		
		String condicao = "where ";

		if (id != null && id != 0) {
			query += condicao + "COD_PRODUTOS = (:id)";
			condicao = " and ";
		}

		if (descricao != null && descricao != "") {
			query += condicao + "DESCRICAO ILIKE (:descricao)";
			condicao = " and ";
		}

		if(inativo != null && inativo != "") {
			if (inativo.equals("F")) {
				query += condicao + "INATIVO = (:inativo)";
				condicao = " and ";
			}
		}
		
		query+="ORDER BY COD_PRODUTOS LIMIT "+limite;

		Query q = em.createNativeQuery(query, Product.class);

		if (id != null && id != 0) {
			q.setParameter("id",id);
		}

		if (descricao != null && descricao != "") {
			q.setParameter("descricao", "%" + descricao + "%");
		}
		
		if(inativo != null && inativo != "") {
			if (inativo.equals("F") ) {
				q.setParameter("inativo", inativo);
			}
		}

		return q.getResultList();
	}
	
}
