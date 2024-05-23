package br.com.matteusmoreno.yellow_tech_backend_challenge.controller;

import br.com.matteusmoreno.yellow_tech_backend_challenge.entity.Category;
import br.com.matteusmoreno.yellow_tech_backend_challenge.request.CreateCategoryRequest;
import br.com.matteusmoreno.yellow_tech_backend_challenge.request.CreatePostRequest;
import br.com.matteusmoreno.yellow_tech_backend_challenge.response.CategoryDetailsResponse;
import br.com.matteusmoreno.yellow_tech_backend_challenge.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/create")
    public ResponseEntity<CategoryDetailsResponse> create(@RequestBody @Valid CreateCategoryRequest request, UriComponentsBuilder urBuilder) {
        Category category = categoryService.createCategory(request);
        URI uri = urBuilder.path("/categories/create/{id}").buildAndExpand(category.getId()).toUri();

        return ResponseEntity.created(uri).body(new CategoryDetailsResponse(category));
    }
}
