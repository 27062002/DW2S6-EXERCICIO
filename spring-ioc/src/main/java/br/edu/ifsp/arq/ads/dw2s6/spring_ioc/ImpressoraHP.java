package br.edu.ifsp.arq.ads.dw2s6.spring_ioc;

import org.springframework.stereotype.Component;

@Component
public class ImpressoraHP implements Impressora {
	
	@Override
	public void imprimir(String documento) {
		System.out.println("Imprimindo na HP: " + documento);
	}
}
