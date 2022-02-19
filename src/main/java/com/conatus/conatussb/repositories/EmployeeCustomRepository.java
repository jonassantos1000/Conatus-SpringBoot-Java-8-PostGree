package com.conatus.conatussb.repositories;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.conatus.conatussb.entities.Employee;


@Repository
@Transactional
public class EmployeeCustomRepository {

	public EmployeeCustomRepository(EntityManager em) {
		super();
		this.em = em;
	}

	private final EntityManager em;

	public List<Employee> find(Long id, String nome, String cpf, String rg, String email, String limite) {
		String query = "SELECT * FROM FUNCIONARIO ";
		String condicao = "where ";

		if (id != null) {
			query += condicao + "CODIGO = (:id)";
			condicao = "and ";
		}

		if (nome != null) {
			query += condicao + "NOME ILIKE (:nome)";
			condicao = "and ";
		}

		if (cpf != null) {
			query += condicao + "CPF ILIKE(:cpf)";
			condicao = "and ";
		}

		if (rg != null) {
			query += condicao + "RG ILIKE(:rg)";
			condicao = "and ";
		}

		if (email != null) {
			query += condicao + "EMAIL ILIKE (:email)";
			condicao = "and ";
		}

		query+="ORDER BY CODIGO LIMIT "+limite;
		
		Query q = em.createNativeQuery(query, Employee.class);

		if (id != null) {
			q.setParameter("id", id);
		}

		if (nome != null) {
			q.setParameter("nome", "%" + nome + "%");
		}

		if (cpf != null) {
			q.setParameter("cpf", "%" + cpf + "%");
		}

		if (rg != null) {
			q.setParameter("rg", "%" + rg + "%");
		}

		if (email != null) {
			q.setParameter("email", "%" + email + "%");
		}

		return q.getResultList();
	}

}
