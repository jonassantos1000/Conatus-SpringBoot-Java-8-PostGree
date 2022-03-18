package com.conatus.conatussb.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conatus.conatussb.entities.Setting;
import com.conatus.conatussb.repositories.ConfiguracaoRepository;
import com.conatus.conatussb.service.exceptions.ResourceNotFoundException;

@Service
public class ConfiguracaoService {
	
	@Autowired
	ConfiguracaoRepository repository;
	
	public Setting find() {
		Optional<Setting> obj= repository.findById((long) 1);
		return obj.orElseThrow(() -> new ResourceNotFoundException("Id Setting: "+ obj.get().getCodigo()));
	}
	
	
	public Setting update(Setting obj) {
		try {
			Setting config = repository.getOne((long) 1);
			updateData(config,obj);
			return repository.save(config);	
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id Setting: " +obj.getCodigo());
		}
	}
	
	public void updateData(Setting entity, Setting obj) {
		entity.setCnpj(obj.getCnpj());
		entity.setData(obj.getData());
		entity.setEmail(obj.getEmail());
		entity.setMensagemPadrao(obj.getMensagemPadrao());
		entity.setPortaSMTP(obj.getPortaSMTP());
		entity.setRazaoSocial(obj.getRazaoSocial());
		entity.setResponsavelLegal(obj.getResponsavelLegal());
		entity.setSenha(obj.getSenha());
		entity.setSmtp(obj.getSmtp());
		entity.setSSL(obj.getSSL());
		entity.setTLS(obj.getTLS());
	}
	
}
