package br.com.matteusmoreno.yellow_tech_backend_challenge.repository;

import br.com.matteusmoreno.yellow_tech_backend_challenge.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
