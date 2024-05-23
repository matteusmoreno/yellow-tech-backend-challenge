package br.com.matteusmoreno.yellow_tech_backend_challenge.request;

import jakarta.validation.constraints.NotNull;

public record UpdateUserRequest(
        @NotNull
        Long id,
        String name,
        String description) {
}
