package com.jvn.controlAccess.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jvn.controlAccess.Collection.Pais;
import com.jvn.controlAccess.IRepository.IPaisRepository;
import com.jvn.controlAccess.IService.IPaisService;
@Service
public class PaisService implements IPaisService {

	@Autowired
	private IPaisRepository repository;
	
	@Override
	public List<Pais> all() {
		return repository.findAll();
	}

	@Override
	public Optional<Pais> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public Pais save(Pais pais) {
		return repository.save(pais);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);		
	}
	
}
