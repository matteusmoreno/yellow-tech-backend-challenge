package br.com.matteusmoreno.yellow_tech_backend_challenge.response;

import br.com.matteusmoreno.yellow_tech_backend_challenge.entity.User;

public record ShortUserResponse(
        Long id,
        String name) {

    public ShortUserResponse(User user) {
        this(user.getId(), user.getName());
    }
}
