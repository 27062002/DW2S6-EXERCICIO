package br.edu.ifsp.arq.ads.dw2s6.atv4.resource;

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

import br.edu.ifsp.arq.ads.dw2s6.atv4.domain.model.FormaPagamento;
import br.edu.ifsp.arq.ads.dw2s6.atv4.repository.FormaPagamentoRepository;
import br.edu.ifsp.arq.ads.dw2s6.atv4.service.FormaPagamentoService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/forma_pagamento")
public class FormaPagamentoResource {
	
	@Autowired
	private FormaPagamentoService formaPagamentoService;
	
	@Autowired
	private FormaPagamentoRepository formaPagamentoRepository;
	
	@GetMapping
	public List<FormaPagamento> read(){
		return formaPagamentoRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public FormaPagamento create(@Valid @RequestBody FormaPagamento formaPagamento, HttpServletResponse response) {
		return formaPagamentoRepository.save(formaPagamento);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FormaPagamento> findById(@PathVariable Long id){
		Optional<FormaPagamento> user = formaPagamentoRepository.findById(id);
		if(user.isPresent()) {
			return ResponseEntity.ok(user.get());
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(@PathVariable Long id) {
		formaPagamentoRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<FormaPagamento> update(@PathVariable Long id, @Valid @RequestBody FormaPagamento formaPagamento) {
		FormaPagamento formaPagamentoSaved = formaPagamentoService.update(id, formaPagamento);
		return ResponseEntity.ok(formaPagamentoSaved);
	}
}
