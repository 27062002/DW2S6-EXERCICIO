package br.edu.ifsp.arq.ads.dw2s6.atv4.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.ifsp.arq.ads.dw2s6.atv4.domain.model.FormaPagamento;
import br.edu.ifsp.arq.ads.dw2s6.atv4.repository.FormaPagamentoRepository;

@Service
public class FormaPagamentoService {
	
	@Autowired
	private FormaPagamentoRepository formaPagamentoRepository;
	
	public FormaPagamento update(Long id, FormaPagamento formaPagamento) {
		FormaPagamento formaPagamentoSaved = findPagamentoById(id);
		BeanUtils.copyProperties(formaPagamento, formaPagamentoSaved, "id");
		return formaPagamentoRepository.save(formaPagamentoSaved);
	}
	
	public FormaPagamento findPagamentoById(Long id) {
		FormaPagamento formaPagamentoSaved = formaPagamentoRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		return formaPagamentoSaved;
	}

}