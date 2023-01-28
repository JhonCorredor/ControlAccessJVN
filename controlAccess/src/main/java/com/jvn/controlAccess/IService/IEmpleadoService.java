package com.jvn.controlAccess.IService;

import java.util.List;
import java.util.Optional;

import com.jvn.controlAccess.Collection.Empleado;

public interface IEmpleadoService {
	
	public List<Empleado> all();

	public Optional<Empleado> findById(Integer id);
	
	public Optional<Empleado> findByCorreoElectronico(String correo);

	public Empleado save(Empleado empleado);

	public void delete(Integer id);
}
