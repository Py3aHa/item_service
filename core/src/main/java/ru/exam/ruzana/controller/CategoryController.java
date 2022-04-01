package ru.exam.ruzana.controller;

import ru.exam.ruzana.dto.CategoryDto;

import java.util.List;

public interface CategoryController {
    void addCategory(CategoryDto categoryDto);

    void updateCategory(CategoryDto categoryDto);

    void deleteCategory(Long id);

    CategoryDto getCategoryById(Long id);

    List<CategoryDto> getAllCategories();
}
