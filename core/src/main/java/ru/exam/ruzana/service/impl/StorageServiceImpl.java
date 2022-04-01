package ru.exam.ruzana.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.exam.ruzana.dto.StorageDto;
import ru.exam.ruzana.model.Storage;
import ru.exam.ruzana.repository.StorageRepository;
import ru.exam.ruzana.service.StorageService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StorageServiceImpl implements StorageService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private StorageRepository storageRepository;

    @Override
    public void save(StorageDto object) {
        Storage storage = modelMapper.map(object, Storage.class);

        storageRepository.insert(storage);
    }

    @Override
    public StorageDto findById(Long id) {
        Storage storage = storageRepository.findById(id);
        return modelMapper.map(storage, StorageDto.class);
    }

    @Override
    public List<StorageDto> findAll() {
        List<Storage> storages = storageRepository.findAll();
        List<StorageDto> storageDtos = storages.stream()
                .map(item -> modelMapper.map(item, StorageDto.class))
                .collect(Collectors.toList());
        return storageDtos;
    }

    @Override
    public void update(StorageDto object) {
        Storage storage = modelMapper.map(object, Storage.class);
        storage.setUpdatedAt(LocalDateTime.now());
        storageRepository.update(storage);
    }

    @Override
    public void delete(Long id) {
        storageRepository.delete(id);
    }

    @Override
    public void addQuantity(int quantity, Long id) {
        Storage storage = storageRepository.findById(id);
        storageRepository.addQuantity(storage.getQuantity() + quantity, id);
    }

    @Override
    public List<StorageDto> getAllByQuantity() {
        List<Storage> storages = storageRepository.findAllByQuantity();
        List<StorageDto> storageDtos = storages.stream()
                .map(item -> modelMapper.map(item, StorageDto.class))
                .collect(Collectors.toList());
        return storageDtos;
    }

    @Override
    public List<StorageDto> getAllStorageByCategory(Long id) {
        List<Storage> storages = storageRepository.findAllByCategoryId(id);
        List<StorageDto> storageDtos = storages.stream()
                .map(item -> modelMapper.map(item, StorageDto.class))
                .collect(Collectors.toList());
        return storageDtos;
    }
}
