package ru.exam.ruzana.service;

import ru.exam.ruzana.dto.CategoryDto;

public interface CategoryService extends BasicCRUDService<CategoryDto> {
    CategoryDto getByName(String name);
}
