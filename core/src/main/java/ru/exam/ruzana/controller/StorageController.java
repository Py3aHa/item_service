package ru.exam.ruzana.controller;

import ru.exam.ruzana.dto.StorageDto;

import java.util.List;

public interface StorageController {
    void addStorage(StorageDto storageDto);

    void updateStorage(StorageDto storageDto);

    void deleteStorage(Long id);

    StorageDto getStorageById(Long id);

    List<StorageDto> getAll();

    List<StorageDto> getAllIfExist();

    List<StorageDto> getAllByCategory(Long id);

    void addQuantity(int quantity, Long id);
}
