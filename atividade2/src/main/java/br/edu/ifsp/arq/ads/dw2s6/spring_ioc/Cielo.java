package br.edu.ifsp.arq.ads.dw2s6.spring_ioc;

import org.springframework.stereotype.Component;

@Component
public class Cielo implements Operadora{

	@Override
	public void autorizar(String numero, int valor) {
		if(valor < 1000 && numero.contains("1234")) {
			System.out.println("Compra autorizada");
		}else {
			System.out.println("Compra não autorizada");
		}
	}

}
