package br.edu.ifsp.arq.ads.dw2s6.sistemaReserva.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.ifsp.arq.ads.dw2s6.sistemaReserva.domain.model.Recurso;
import br.edu.ifsp.arq.ads.dw2s6.sistemaReserva.repository.RecursoRepository;

@Service
public class RecursoService {

	@Autowired
	private RecursoRepository recursoRepository;
	
	public Recurso update(Long id, Recurso recurso) {
		Recurso recursoSaved = findRecursoById(id);
		BeanUtils.copyProperties(recurso, recursoSaved, "id");
		return recursoRepository.save(recursoSaved);
	}
	
	public Recurso findRecursoById(Long id) {
		Recurso recursoSaved = recursoRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		return recursoSaved;
	}
}
