package ru.exam.ruzana.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.exam.ruzana.dto.CategoryDto;
import ru.exam.ruzana.model.Category;
import ru.exam.ruzana.repository.CategoryRepository;
import ru.exam.ruzana.service.CategoryService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void save(CategoryDto object) {
        Category category = modelMapper.map(object, Category.class);
        categoryRepository.insert(category);
    }

    @Override
    public CategoryDto findById(Long id) {
        Category category = categoryRepository.findById(id);
        CategoryDto categoryDto = modelMapper.map(category, CategoryDto.class);
        return categoryDto;
    }

    @Override
    public List<CategoryDto> findAll() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDto> categoryDtos = categories.stream()
                .map(item -> modelMapper.map(item, CategoryDto.class))
                .collect(Collectors.toList());
        return categoryDtos;
    }

    @Override
    public void update(CategoryDto object) {
        categoryRepository.update(modelMapper.map(object, Category.class));
    }

    @Override
    public void delete(Long id) {
        categoryRepository.delete(id);
    }

    @Override
    public CategoryDto getByName(String name) {
        Category category = categoryRepository.findByName(name);
        return modelMapper.map(category, CategoryDto.class);
    }
}
