package br.com.matteusmoreno.yellow_tech_backend_challenge.request;

import jakarta.validation.constraints.NotNull;

public record UpdateCategoryRequest(
        @NotNull
        Long id,
        String name) {
}
