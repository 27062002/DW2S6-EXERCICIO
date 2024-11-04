package br.edu.ifsp.arq.ads.dw2s6.sistemaReserva.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.ifsp.arq.ads.dw2s6.sistemaReserva.domain.model.Reserva;
import br.edu.ifsp.arq.ads.dw2s6.sistemaReserva.repository.ReservaRepository;

@Service
public class ReservaService {

	@Autowired
	private ReservaRepository reservaRepository;
	
	public Reserva update(Long id, Reserva reserva) {
		Reserva reservaSaved = findReservaById(id);
		BeanUtils.copyProperties(reserva, reservaSaved, "id");
		return reservaRepository.save(reservaSaved);
	}
	
	public Reserva findReservaById(Long id) {
		Reserva reservaSaved = reservaRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		return reservaSaved;
	}
}
