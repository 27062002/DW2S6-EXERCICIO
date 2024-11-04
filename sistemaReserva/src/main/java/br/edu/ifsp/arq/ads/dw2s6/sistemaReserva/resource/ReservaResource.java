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
import br.edu.ifsp.arq.ads.dw2s6.sistemaReserva.domain.model.Reserva;
import br.edu.ifsp.arq.ads.dw2s6.sistemaReserva.repository.ReservaRepository;
import br.edu.ifsp.arq.ads.dw2s6.sistemaReserva.service.ReservaService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/reservas")
public class ReservaResource {

	@Autowired
	private ReservaRepository reservaRepository;
	
	@Autowired
	private ReservaService reservaService;
	
	@GetMapping
	public List<Reserva> list(){
		return reservaRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Reserva create(@Valid @RequestBody Reserva reserva, HttpServletResponse response) {
		return reservaRepository.save(reserva);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Reserva> findById(@PathVariable Long id){
		Optional<Reserva> reserva = reservaRepository.findById(id);
		if(reserva.isPresent()) {
			return ResponseEntity.ok(reserva.get());
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(@PathVariable Long id) {
		reservaRepository.deleteById(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Reserva> update(@PathVariable Long id, @Valid @RequestBody Reserva reserva) {
		Reserva reservaSaved = reservaService.update(id, reserva);
		return ResponseEntity.ok(reservaSaved);
	}
}
