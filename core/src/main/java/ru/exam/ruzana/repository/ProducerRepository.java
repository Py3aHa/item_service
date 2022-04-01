package ru.exam.ruzana.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ru.exam.ruzana.model.Producer;

import java.util.List;

@Mapper
public interface ProducerRepository {
    void insert(Producer producerDto);

    void update(Producer producerDto);

    void delete(Long id);

    @Select("select * from producer where id = #{id}")
    Producer findById(Long id);

    @Select("select * from producer where name = #{name}")
    Producer findByName(String name);

    @Select("select * from producer")
    List<Producer> findAll();
}
