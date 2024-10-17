package br.edu.ifsp.arq.ads.dw2s6.atv4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsp.arq.ads.dw2s6.atv4.domain.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
