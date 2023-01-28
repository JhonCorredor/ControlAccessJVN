package com.jvn.controlAccess.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jvn.controlAccess.Collection.Empleado;
import com.jvn.controlAccess.Collection.Pais;
import com.jvn.controlAccess.IRepository.IEmpleadoRepository;
import com.jvn.controlAccess.IService.IEmpleadoService;

@Service
public class EmpleadoService implements IEmpleadoService {

	@Autowired
	private IEmpleadoRepository repository;
	
	@Override
	public List<Empleado> all() {
		return repository.findAll();
	}

	@Override
	public Optional<Empleado> findById(Integer id) {
		return repository.findById(id);
	}
	
	@Override
	public Optional<Empleado> findByCorreoElectronico(String correo) {
		
		return repository.findByCorreoElectronico(correo);
	}

	@Override
	public Empleado save(Empleado empleado) {
		String dominioCo = "@jvntecnologias.com";
		String dominioUs = "@jvntecnologias.com.us";
		String correo = "";
		Empleado emplea = repository.save(empleado);
		if (emplea.getPaisId().getId() == 1) {
			correo = emplea.getPrimerNombre() + "." + emplea.getPrimerApellido() + "." + emplea.getId() + dominioCo;
		}
		else {
			correo = emplea.getPrimerNombre() + "." + emplea.getPrimerApellido() + "." + emplea.getId() + dominioUs;
		}
		empleado.setCorreoElectronico(correo);
		
		
		return repository.save(empleado);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}

}
