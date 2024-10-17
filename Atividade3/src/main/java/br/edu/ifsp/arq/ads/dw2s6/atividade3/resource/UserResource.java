package br.edu.ifsp.arq.ads.dw2s6.atividade3.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.arq.ads.dw2s6.atividade3.domain.model.User;
import br.edu.ifsp.arq.ads.dw2s6.atividade3.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UserResource {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public List<User> read(){
		return userRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User create(@Valid @RequestBody User user, HttpServletResponse response) {
		return userRepository.save(user);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<User> findById(@PathVariable Long codigo){
		Optional<User> user = userRepository.findById(codigo);
		if(user.isPresent()) {
			return ResponseEntity.ok(user.get());
		}
		return ResponseEntity.notFound().build();
	}

}