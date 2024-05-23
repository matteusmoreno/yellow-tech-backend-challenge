package br.com.matteusmoreno.yellow_tech_backend_challenge.response;

import br.com.matteusmoreno.yellow_tech_backend_challenge.entity.Category;
import br.com.matteusmoreno.yellow_tech_backend_challenge.entity.Post;

import java.time.LocalDateTime;

public record PostDetailsResponse(
        Long id,
        ShortUserResponse user,
        String title,
        String content,
        Category category,
        int views,
        LocalDateTime createdAt) {

    public PostDetailsResponse(Post post) {
        this(post.getId(), new ShortUserResponse(post.getUser()), post.getTitle(), post.getContent(), post.getCategory(),
                post.getViews(), post.getCreatedAt());
    }
}
