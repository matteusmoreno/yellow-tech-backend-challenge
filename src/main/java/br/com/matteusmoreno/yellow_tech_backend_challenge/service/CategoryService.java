package br.com.matteusmoreno.yellow_tech_backend_challenge.service;

import br.com.matteusmoreno.yellow_tech_backend_challenge.entity.Category;
import br.com.matteusmoreno.yellow_tech_backend_challenge.repository.CategoryRepository;
import br.com.matteusmoreno.yellow_tech_backend_challenge.request.CreateCategoryRequest;
import br.com.matteusmoreno.yellow_tech_backend_challenge.request.UpdateCategoryRequest;
import br.com.matteusmoreno.yellow_tech_backend_challenge.response.CategoryDetailsResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public Category createCategory(CreateCategoryRequest request) {
        Category category = new Category();
        BeanUtils.copyProperties(request, category);

        categoryRepository.save(category);

        return category;
    }

    public Category categoryDetails(Long id) {
        return categoryRepository.findById(id).orElseThrow();
    }

    public Page<CategoryDetailsResponse> listAllCategories(Pageable pageable) {
        return categoryRepository.findAll(pageable).map(CategoryDetailsResponse::new);
    }

    @Transactional
    public Category updateCategory(UpdateCategoryRequest request) {
        Category category = categoryRepository.findById(request.id()).orElseThrow();

        if (request.name() != null) {
            category.setName(request.name());
        }

        categoryRepository.save(category);

        return category;
    }

    @Transactional
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }


}
