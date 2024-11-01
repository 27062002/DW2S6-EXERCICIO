package br.edu.ifsp.arq.ads.dw2s6.atv4.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.arq.ads.dw2s6.atv4.domain.model.OrdemServico;
import br.edu.ifsp.arq.ads.dw2s6.atv4.repository.OrdemServicoRepository;
import br.edu.ifsp.arq.ads.dw2s6.atv4.service.OrdemServicoServive;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/ordem_servico")
public class OrdemServicoResource {
		
		@Autowired
		private OrdemServicoServive ordemServicoService;
		
		@Autowired
		private OrdemServicoRepository ordemServicoRepository;
		
		@GetMapping
		@PreAuthorize("hasAuthority('ROLE_SEARCH_SERVICE') and hasAuthority('SCOPE_read')")
		public List<OrdemServico> read(){
			return ordemServicoRepository.findAll();
		}
		
		@PostMapping
		@ResponseStatus(HttpStatus.CREATED)
		@PreAuthorize("hasAuthority('ROLE_REGISTER_SERVICE') and hasAuthority('SCOPE_write')")
		public OrdemServico create(@Valid @RequestBody OrdemServico ordemServico, HttpServletResponse response) {
			return ordemServicoRepository.save(ordemServico);
		}
		
		@GetMapping("/{id}")
		@PreAuthorize("hasAuthority('ROLE_SEARCH_SERVICE') and hasAuthority('SCOPE_read')")
		public ResponseEntity<OrdemServico> findById(@PathVariable Long id){
			Optional<OrdemServico> ordem = ordemServicoRepository.findById(id);
			if(ordem.isPresent()) {
				return ResponseEntity.ok(ordem.get());
			}
			return ResponseEntity.notFound().build();
		}

		@DeleteMapping("/{id}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		@PreAuthorize("hasAuthority('ROLE_REMOVE_SERVICE') and hasAuthority('SCOPE_write')")
		public void remove(@PathVariable Long id) {
			ordemServicoRepository.deleteById(id);
		}
		
		@PutMapping("/{id}")
		@PreAuthorize("hasAuthority('ROLE_REGISTER_SERVICE') and hasAuthority('SCOPE_write')")
		public ResponseEntity<OrdemServico> update(@PathVariable Long id, @Valid @RequestBody OrdemServico ordemServico) {
			OrdemServico ordemServicoSaved = ordemServicoService.update(id, ordemServico);
			return ResponseEntity.ok(ordemServicoSaved);
		}
	}
