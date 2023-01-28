package com.jvn.controlAccess.IService;

import java.util.List;
import java.util.Optional;

import com.jvn.controlAccess.Collection.ControlAccess;

public interface IControlAccessService {
	
	public List<ControlAccess> all();

	public Optional<ControlAccess> findById(Integer id);

	public ControlAccess save(ControlAccess controlAccess);

	public void delete(Integer id);
}
