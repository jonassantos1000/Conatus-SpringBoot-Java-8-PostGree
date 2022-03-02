package com.conatus.conatussb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.conatus.conatussb.entities.reports.Report;
import com.conatus.conatussb.service.ReportService;

@RestController
@RequestMapping(value = "/reports")
public class ReportResource {
	
	@Autowired
	ReportService service;
		
	@GetMapping
	public ResponseEntity<List<Report>> findAll(){
		List<Report> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
}
