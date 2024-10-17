package br.edu.ifsp.arq.ads.dw2s6.spring_ioc;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.edu.ifsp.arq.ads.dw2s6.spring_ioc.model.Cartao;

@Component
public class Checkout {
	
	var Cartao1 = new Cartao();
	
	@Autowired
	@Qualifier("cielo")
	private Operadora operadora;
	
	
	
	public void finalizar() {
		operadora.autorizar("11234", 1);
	}
}
