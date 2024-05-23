package br.com.matteusmoreno.yellow_tech_backend_challenge.response;

import br.com.matteusmoreno.yellow_tech_backend_challenge.entity.Post;
import br.com.matteusmoreno.yellow_tech_backend_challenge.entity.User;

import java.util.List;

public record UserDetailsResponse(
        Long id,
        String name,
        String description,
        List<Post> posts) {

    public UserDetailsResponse(User user) {
        this(user.getId(), user.getName(), user.getDescription(), user.getPosts());
    }
}
