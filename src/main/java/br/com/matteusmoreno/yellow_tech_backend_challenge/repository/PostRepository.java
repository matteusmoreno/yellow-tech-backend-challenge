package br.com.matteusmoreno.yellow_tech_backend_challenge.repository;

import br.com.matteusmoreno.yellow_tech_backend_challenge.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
