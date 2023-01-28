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

import com.jvn.controlAccess.Collection.ControlAccess;
import com.jvn.controlAccess.IService.IControlAccessService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/ControlAccess")
public class ControlAccessController {
	
	@Autowired
	private IControlAccessService service;
	
	@GetMapping
	public List<ControlAccess> all(){
		return service.all();
	}
 	
	@GetMapping("{id}")
	public Optional<ControlAccess> show(@PathVariable Integer id){
		return service.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ControlAccess save(@RequestBody ControlAccess controllAccess) {
		return service.save(controllAccess);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ControlAccess Update(@PathVariable Integer id, @RequestBody ControlAccess controlAccess) {
		Optional<ControlAccess> op = service.findById(id);
		
		if (!op.isEmpty()) {
			ControlAccess controlAccessUpdate = op.get();
			controlAccessUpdate.setId(controlAccess.getId());
			controlAccessUpdate.setFecha(controlAccess.getFecha());
			controlAccessUpdate.setEmpleadoId(controlAccess.getEmpleadoId());
			return service.save(controlAccessUpdate);
		}
		
		return controlAccess;
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code= HttpStatus.NO_CONTENT)
	public void Delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
	
}
