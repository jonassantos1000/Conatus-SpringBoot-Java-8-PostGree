package com.conatus.conatussb.repositories;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.conatus.conatussb.entities.reports.Report;


@Repository
@Transactional
public class ReportCustomRepository {

	public ReportCustomRepository(EntityManager em) {
		super();
		this.em = em;
	}

	private final EntityManager em;

	public List<Report> findAll() {
		String query = "SELECT * FROM RELATORIOS r ORDER BY r.COD_RELATORIO,r.CATEGORIA";

		Query q = em.createNativeQuery(query, Report.class);

		return q.getResultList();
	}

}
