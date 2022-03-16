package com.conatus.conatussb.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.conatus.conatussb.entities.Order;
import com.conatus.conatussb.entities.OrderItem;
import com.conatus.conatussb.entities.User;
import com.conatus.conatussb.repositories.OrderCustomRepository;
import com.conatus.conatussb.repositories.OrderRepository;
import com.conatus.conatussb.service.exceptions.ResourceNotFoundException;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository repository;
	
	@Autowired
	OrderCustomRepository repositoryCustom;
		
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public List<Order> findAllCustom(Long codOrder,Long codClient,String nameClient,String cpfClient,String rgClient,String nameEmployee,String data,String limite){
		return repositoryCustom.findCustom(codOrder, codClient, nameClient, cpfClient, rgClient, nameEmployee, data, limite);
	}
	
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException("Id Order: "+id));
	}

	public Order insert(Order obj) {
		return repositoryCustom.insert(obj);	
	}
	
	public Order update(Long id, Order obj) {
		try {
			Order entity = repository.getOne(id);
			delete(id);
			return repositoryCustom.insert(obj);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id Order: " +id);
		}
	}
		
	public void delete(Long id) {
		try {
			repository.deleteById(id);

		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id Order: " + id);
		}
	}
		
}
