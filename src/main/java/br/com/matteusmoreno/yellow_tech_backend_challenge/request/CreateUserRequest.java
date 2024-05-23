package br.com.matteusmoreno.yellow_tech_backend_challenge.request;

import jakarta.validation.constraints.NotBlank;

public record CreateUserRequest(
        @NotBlank
        String name,
        String description) {
}
