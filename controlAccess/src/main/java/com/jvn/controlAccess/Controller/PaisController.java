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

import com.jvn.controlAccess.Collection.Pais;
import com.jvn.controlAccess.IService.IPaisService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/pais")
public class PaisController {
	
	@Autowired
	private IPaisService service;
	
	@GetMapping
	public List<Pais> all(){
		return service.all();
	}
 	
	@GetMapping("{id}")
	public Optional<Pais> show(@PathVariable Integer id){
		return service.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Pais save(@RequestBody Pais pais) {
		return service.save(pais);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Pais Update(@PathVariable Integer id, @RequestBody Pais pais) {
		Optional<Pais> op = service.findById(id);
		
		if (!op.isEmpty()) {
			Pais paisUpdate = op.get();
			paisUpdate.setId(pais.getId());
			paisUpdate.setNombre(pais.getNombre());
			return service.save(paisUpdate);
		}
		
		return pais;
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code= HttpStatus.NO_CONTENT)
	public void Delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
	
}
