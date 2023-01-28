package com.jvn.controlAccess.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jvn.controlAccess.Collection.Empleado;
import com.jvn.controlAccess.IService.IEmpleadoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/empleado")
public class EmpleadoController {
	
	@Autowired
	private IEmpleadoService service;
	
	@GetMapping
	public List<Empleado> all(){
		return service.all();
	}
 	
	@GetMapping("{id}")
	public Optional<Empleado> show(@PathVariable Integer id){
		return service.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Empleado save(@RequestBody Empleado empleado) {
		return service.save(empleado);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Empleado Update(@PathVariable Integer id, @RequestBody Empleado empleado) {
		Optional<Empleado> op = service.findById(id);
		
		if (!op.isEmpty()) {
			Empleado empleadoUpdate = op.get();
			empleadoUpdate.setId(empleado.getId());
			empleadoUpdate.setPrimerApellido(empleado.getPrimerApellido());
			empleadoUpdate.setPrimerNombre(empleado.getPrimerNombre());
			empleadoUpdate.setOtrosNombres(empleado.getOtrosNombres());
			empleadoUpdate.setPaisId(empleado.getPaisId());
			return service.save(empleadoUpdate);
		}
		
		return empleado;
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code= HttpStatus.NO_CONTENT)
	public void Delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
	
}
