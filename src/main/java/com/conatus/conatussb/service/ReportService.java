package com.conatus.conatussb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conatus.conatussb.entities.reports.Report;
import com.conatus.conatussb.entities.reports.TotalizerPerMonth;
import com.conatus.conatussb.repositories.ReportCustomRepository;


@Service
public class ReportService {
		
	@Autowired
	ReportCustomRepository custom;
	
	public List<Report> findAll(){
		return custom.findAll();
	}

	public List<TotalizerPerMonth> totalizerPerMonth(Integer ano){
		return custom.totalizerPerMonth(ano);
	}
}
