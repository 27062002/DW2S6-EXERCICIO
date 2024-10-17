package br.edu.ifsp.arq.ads.dw2s6.iftec.resource;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.arq.ads.dw2s6.iftec.domain.model.Clientes;

@RestController
public class ClientResourse {

	@GetMapping("/clientes")
	public List<Clientes> list(){
		var Cliente1 = new Clientes();
		Cliente1.setCodigo(1L);
		Cliente1.setNome("Gabriel");
		Cliente1.setEmail("gabriel@ifsp.edu.br");
		Cliente1.setTelefone("(16)99999-9999");
		
		var Cliente2 = new Clientes();
		Cliente2.setCodigo(2L);
		Cliente2.setNome("João");
		Cliente2.setEmail("joao@ifsp.edu.br");
		Cliente2.setTelefone("(16)99999-9998");
		
		return Arrays.asList(Cliente1, Cliente2);
	}
}
