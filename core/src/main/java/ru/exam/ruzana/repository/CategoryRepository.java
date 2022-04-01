package ru.exam.ruzana.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ru.exam.ruzana.model.Category;

import java.util.List;

@Mapper
public interface CategoryRepository {
    void insert(Category category);

    void update(Category category);

    void delete(Long id);

    @Select("select * from category where id = #{id}")
    Category findById(Long id);

    @Select("select * from category where name = #{name}")
    Category findByName(String name);

    @Select("select * from category")
    List<Category> findAll();
}
