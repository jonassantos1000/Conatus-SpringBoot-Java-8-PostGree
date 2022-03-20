package com.conatus.conatussb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conatus.conatussb.entities.Counters;
import com.conatus.conatussb.repositories.CountersCustomRepository;

@Service
public class CountersService {
	
	@Autowired
	CountersCustomRepository repository;
	
	public List<Counters> consultaCodigo(String campo) {
		List<Counters> count = repository.consultaCodigo(campo);
		if(count.isEmpty()==true) {
			createCounters(campo);
			count=consultaCodigo(campo);
		}
		return count;
	}
	
	public void createCounters(String campo) {
		repository.createCounters(campo);
	}
}
