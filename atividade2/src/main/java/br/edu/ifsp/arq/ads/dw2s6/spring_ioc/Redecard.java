package br.edu.ifsp.arq.ads.dw2s6.spring_ioc;

import org.springframework.stereotype.Component;

@Component
public class Redecard implements Operadora{

	@Override
	public void autorizar(String numero, int valor) {
		if(valor < 1000 && numero.indexOf("1234")==0) {
			System.out.println("Compra autorizada");
		}else {
			System.out.println("Compra não autorizada");
		}
	}
}
