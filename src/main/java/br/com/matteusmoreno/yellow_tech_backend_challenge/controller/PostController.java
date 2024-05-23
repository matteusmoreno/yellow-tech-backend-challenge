package br.com.matteusmoreno.yellow_tech_backend_challenge.controller;

import br.com.matteusmoreno.yellow_tech_backend_challenge.entity.Post;
import br.com.matteusmoreno.yellow_tech_backend_challenge.request.CreatePostRequest;
import br.com.matteusmoreno.yellow_tech_backend_challenge.request.UpdatePostRequest;
import br.com.matteusmoreno.yellow_tech_backend_challenge.response.PostDetailsResponse;
import br.com.matteusmoreno.yellow_tech_backend_challenge.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/create")
    public ResponseEntity<PostDetailsResponse> createPost(@RequestBody @Valid CreatePostRequest request, UriComponentsBuilder uriBuilder) {
        Post post = postService.createPost(request);
        URI uri = uriBuilder.path("/posts/create/{id}").buildAndExpand(post.getId()).toUri();

        return ResponseEntity.created(uri).body(new PostDetailsResponse(post));
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<PostDetailsResponse> details(@PathVariable Long id) {
        Post post = postService.postDetails(id);

        return ResponseEntity.ok(new PostDetailsResponse(post));
    }

    @PutMapping("/update")
    public ResponseEntity<PostDetailsResponse> update(@RequestBody @Valid UpdatePostRequest request) {
        Post post = postService.updatePost(request);

        return ResponseEntity.ok(new PostDetailsResponse(post));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        postService.deletePost(id);

        return ResponseEntity.noContent().build();
    }
}
