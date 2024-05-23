package br.com.matteusmoreno.yellow_tech_backend_challenge.service;

import br.com.matteusmoreno.yellow_tech_backend_challenge.entity.Category;
import br.com.matteusmoreno.yellow_tech_backend_challenge.repository.CategoryRepository;
import br.com.matteusmoreno.yellow_tech_backend_challenge.request.CreateCategoryRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
}
