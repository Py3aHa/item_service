package ru.exam.ruzana.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ru.exam.ruzana.model.Storage;

import java.util.List;

@Mapper
public interface StorageRepository {
    void insert(Storage storage);

    void update(Storage storage);

    void delete(Long id);

    @Select("select * from storage where id = #{id}")
    Storage findById(Long id);

    @Select("select * from storage")
    List<Storage> findAll();

    @Select("select * from storage where quantity > 0")
    List<Storage> findAllByQuantity();

    List<Storage> findAllByCategoryId(Long id);

    void addQuantity(int quantity, Long id);
}
