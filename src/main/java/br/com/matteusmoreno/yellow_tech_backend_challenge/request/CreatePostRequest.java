package br.com.matteusmoreno.yellow_tech_backend_challenge.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreatePostRequest(
        @NotNull
        Long user,
        @NotBlank
        String title,
        @NotBlank
        String content,
        @NotNull
        Long category) {
}
