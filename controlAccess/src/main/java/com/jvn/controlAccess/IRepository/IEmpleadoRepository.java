package com.jvn.controlAccess.IRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jvn.controlAccess.Collection.Empleado;

public interface IEmpleadoRepository extends JpaRepository<Empleado, Integer> {

	public Optional<Empleado> findByCorreoElectronico(String correo);
}