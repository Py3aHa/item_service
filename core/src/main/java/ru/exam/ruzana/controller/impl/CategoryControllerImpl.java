package ru.exam.ruzana.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.exam.ruzana.controller.CategoryController;
import ru.exam.ruzana.dto.CategoryDto;
import ru.exam.ruzana.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/categories")
public class CategoryControllerImpl implements CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Override
    @PostMapping(path = "/admin/")
    public void addCategory(@RequestBody CategoryDto categoryDto) {
        categoryService.save(categoryDto);
    }

    @Override
    @PatchMapping(path =  "/admin/")
    public void updateCategory(@RequestBody CategoryDto categoryDto) {
        categoryService.update(categoryDto);
    }

    @Override
    @DeleteMapping(path = "/admin/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
    }

    @Override
    @GetMapping(path = "/user/{id}")
    public CategoryDto getCategoryById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @Override
    @GetMapping(path = "/user/")
    public List<CategoryDto> getAllCategories() {
        return categoryService.findAll();
    }
}
