package br.com.matteusmoreno.yellow_tech_backend_challenge.request;

public record UpdatePostRequest(
        Long id,
        String title,
        String content,
        Long category) {
}
