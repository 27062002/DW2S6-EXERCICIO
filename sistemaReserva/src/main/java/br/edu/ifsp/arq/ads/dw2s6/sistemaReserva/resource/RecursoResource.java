package br.edu.ifsp.arq.ads.dw2s6.sistemaReserva.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.arq.ads.dw2s6.sistemaReserva.domain.model.Recurso;
import br.edu.ifsp.arq.ads.dw2s6.sistemaReserva.repository.RecursoRepository;
import br.edu.ifsp.arq.ads.dw2s6.sistemaReserva.service.RecursoService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/recursos")
public class RecursoResource {
	
	@Autowired
	private RecursoRepository recursoRepository;
	
	@Autowired
	private RecursoService recursoService;
	
	@GetMapping
	public List<Recurso> list(){
		return recursoRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Recurso create(@Valid @RequestBody Recurso recurso, HttpServletResponse response) {
		return recursoRepository.save(recurso);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Recurso> findById(@PathVariable Long id){
		Optional<Recurso> recurso = recursoRepository.findById(id);
		if(recurso.isPresent()) {
			return ResponseEntity.ok(recurso.get());
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(@PathVariable Long id) {
		recursoRepository.deleteById(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Recurso> update(@PathVariable Long id, @Valid @RequestBody Recurso recurso) {
		Recurso recursoSaved = recursoService.update(id, recurso);
		return ResponseEntity.ok(recursoSaved);
	}
}
