package ru.exam.ruzana.service;

import ru.exam.ruzana.dto.StorageDto;

import java.util.List;

public interface StorageService extends BasicCRUDService<StorageDto> {
    void addQuantity(int quantity, Long id);

    List<StorageDto> getAllByQuantity();

    List<StorageDto> getAllStorageByCategory(Long id);
}
