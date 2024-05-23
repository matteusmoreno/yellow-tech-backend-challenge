package br.com.matteusmoreno.yellow_tech_backend_challenge.response;

import br.com.matteusmoreno.yellow_tech_backend_challenge.entity.Post;

import java.time.LocalDateTime;

public record FeedPostResponse(
        String title,
        String content,
        int views,
        LocalDateTime createdAt) {

    public FeedPostResponse(Post post) {
        this(post.getTitle(), post.getContent(), post.getViews(), post.getCreatedAt());
    }
}
