package br.com.matteusmoreno.yellow_tech_backend_challenge.response;

import br.com.matteusmoreno.yellow_tech_backend_challenge.entity.Category;

public record CategoryDetailsResponse(
        Long id,
        String name) {

    public CategoryDetailsResponse(Category category) {
        this(category.getId(), category.getName());
    }
}
