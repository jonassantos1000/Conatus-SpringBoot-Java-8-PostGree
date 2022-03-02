package com.conatus.conatussb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conatus.conatussb.entities.reports.Report;

public interface ReportRepository extends JpaRepository<Report, Long>{
	
	
}
