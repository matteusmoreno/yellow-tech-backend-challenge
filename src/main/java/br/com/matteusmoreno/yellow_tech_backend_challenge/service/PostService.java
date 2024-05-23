package br.com.matteusmoreno.yellow_tech_backend_challenge.service;

import br.com.matteusmoreno.yellow_tech_backend_challenge.entity.Category;
import br.com.matteusmoreno.yellow_tech_backend_challenge.entity.Post;
import br.com.matteusmoreno.yellow_tech_backend_challenge.entity.User;
import br.com.matteusmoreno.yellow_tech_backend_challenge.repository.CategoryRepository;
import br.com.matteusmoreno.yellow_tech_backend_challenge.repository.PostRepository;
import br.com.matteusmoreno.yellow_tech_backend_challenge.repository.UserRepository;
import br.com.matteusmoreno.yellow_tech_backend_challenge.request.CreatePostRequest;
import br.com.matteusmoreno.yellow_tech_backend_challenge.request.UpdatePostRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public PostService(PostRepository postRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public Post createPost(CreatePostRequest request) {
        Post post = new Post();

        User user = userRepository.findById(request.user()).orElseThrow();
        Category category = categoryRepository.findById(request.category()).orElseThrow();

        post.setUser(user);
        post.setTitle(request.title());
        post.setContent(request.content());
        post.setCategory(category);
        post.setCreatedAt(LocalDateTime.now());

        postRepository.save(post);

        return post;
    }

    public Post postDetails(Long id) {
        return postRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Post updatePost(UpdatePostRequest request) {
        Post post = postRepository.findById(request.id()).orElseThrow();

        if (request.title() != null) {
            post.setTitle(request.title());
        }
        if (request.content() != null) {
            post.setContent(request.content());
        }
        if (request.category() != null) {
            Category category = categoryRepository.findById(request.category()).orElseThrow();
            post.setCategory(category);
        }

        postRepository.save(post);

        return post;
    }
}
