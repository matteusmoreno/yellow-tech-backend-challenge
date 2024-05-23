package br.com.matteusmoreno.yellow_tech_backend_challenge.response;

import br.com.matteusmoreno.yellow_tech_backend_challenge.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public record UserDetailsResponse(
        Long id,
        String name,
        String description,
        List<FeedPostResponse> posts) {

    public UserDetailsResponse(User user) {
        this(user.getId(), user.getName(), user.getDescription(),
                user.getPosts().stream().map(FeedPostResponse::new).collect(Collectors.toList()));
    }
}
