package com.conatus.conatussb.repositories;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.conatus.conatussb.entities.reports.Report;
import com.conatus.conatussb.entities.reports.TotalizerPerMonth;


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
	
	public List<TotalizerPerMonth> totalizerPerMonth(Integer ano) {
		String query = "SELECT  \n"
                + "EXTRACT (MONTH FROM v.DT_VENDA) AS MES,\n"
                + "EXTRACT (YEAR FROM v.DT_VENDA) AS ANO,\n"
                + "count(CAST (v.DT_VENDA AS date )) AS ATENDIMENTOS,\n"
                + "sum(v.vl_total_venda) AS TOTAL\n"
                + "FROM \n"
                + "vendas v";
        if (ano != 0) {
        	query = query + " WHERE EXTRACT (YEAR FROM v.DT_VENDA) BETWEEN '" + ano + "' AND '" + ano + "'";
        }
        query = query + " GROUP BY 1,2 ORDER BY 2,1";
		
		Query q = em.createNativeQuery(query, TotalizerPerMonth.class);

		return q.getResultList();
	}

}
