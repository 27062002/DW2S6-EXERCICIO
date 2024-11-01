package br.edu.ifsp.arq.ads.dw2s6.atv4.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.ifsp.arq.ads.dw2s6.atv4.domain.model.OrdemServico;
import br.edu.ifsp.arq.ads.dw2s6.atv4.repository.OrdemServicoRepository;

@Service
public class OrdemServicoServive {
		
		@Autowired
		private OrdemServicoRepository ordemServicoRepository;
		
		public OrdemServico update(Long id, OrdemServico ordemServico) {
			OrdemServico ordemServicoSaved = findPagamentoById(id);
			BeanUtils.copyProperties(ordemServico, ordemServicoSaved, "id");
			return ordemServicoRepository.save(ordemServicoSaved);
		}
		
		public OrdemServico findPagamentoById(Long id) {
			OrdemServico ordemServicoSaved = ordemServicoRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
			return ordemServicoSaved
					;
		}

}
