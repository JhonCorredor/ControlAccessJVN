package com.jvn.controlAccess.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jvn.controlAccess.Collection.ControlAccess;
import com.jvn.controlAccess.IRepository.IControlAccessRepository;
import com.jvn.controlAccess.IService.IControlAccessService;
@Service
public class ControlAccessService implements IControlAccessService {

	@Autowired
	private IControlAccessRepository repository;
	
	@Override
	public List<ControlAccess> all() {
		return repository.findAll();
	}

	@Override
	public Optional<ControlAccess> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public ControlAccess save(ControlAccess controlAccess) {
		return repository.save(controlAccess);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
}
