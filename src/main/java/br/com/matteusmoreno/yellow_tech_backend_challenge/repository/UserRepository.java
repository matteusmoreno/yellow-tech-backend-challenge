package br.com.matteusmoreno.yellow_tech_backend_challenge.repository;

import br.com.matteusmoreno.yellow_tech_backend_challenge.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
