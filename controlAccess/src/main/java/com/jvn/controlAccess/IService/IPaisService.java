package com.jvn.controlAccess.IService;

import java.util.List;
import java.util.Optional;

import com.jvn.controlAccess.Collection.Pais;

public interface IPaisService {
	
	public List<Pais> all();

	public Optional<Pais> findById(Integer id);

	public Pais save(Pais pais);

	void delete(Integer id);
}
