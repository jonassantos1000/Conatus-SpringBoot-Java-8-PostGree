package com.conatus.conatussb.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.conatus.conatussb.entities.Product;
import com.conatus.conatussb.repositories.ProductCustomRepository;
import com.conatus.conatussb.repositories.ProductRepository;
import com.conatus.conatussb.service.exceptions.ResourceNotFoundException;

@Service
public class ProductService {

	@Autowired
	ProductCustomRepository customRepository;
	
	@Autowired
	ProductRepository repository;

	public List<Product> findCustom(Long id, String desricao, String inativo, String limite) {
		return customRepository.findCustomAll(id, desricao, inativo, limite);
	}
	
	public Product insert(Product obj) {
		return repository.save(obj);
	}
	
	public Product update(Long id, Product obj) {
		try {
			Product entity = repository.getOne(id);
			updateData(entity,obj);
			return repository.save(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id Product: " +id);
		}
	}
	
	public void updateData(Product entity, Product obj) {
		entity.setData_alteracao(obj.getData_alteracao());
		entity.setDescricao(obj.getDescricao());
		entity.setInativo(obj.getInativo());
		entity.setObservacao(obj.getObservacao());
		entity.setPreco(obj.getPreco());
		entity.setUsuario(obj.getUsuario());
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id Product: " + id);
		}
	}
	
}
