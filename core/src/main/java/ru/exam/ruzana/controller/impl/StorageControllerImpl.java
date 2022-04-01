package ru.exam.ruzana.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.exam.ruzana.controller.StorageController;
import ru.exam.ruzana.dto.StorageDto;
import ru.exam.ruzana.service.StorageService;

import java.util.List;

@RestController
    @RequestMapping(path = "/api/storage")
public class StorageControllerImpl implements StorageController {
    @Autowired
    private StorageService storageService;

    @Override
    @PostMapping(path = "/admin/")
    public void addStorage(@RequestBody StorageDto storageDto) {
        storageService.save(storageDto);
    }

    @Override
    @PatchMapping(path = "/admin/")
    public void updateStorage(@RequestBody StorageDto storageDto) {
        storageService.update(storageDto);
    }

    @Override
    @DeleteMapping(path = "/admin/{id}")
    public void deleteStorage(@PathVariable Long id) {
        storageService.delete(id);
    }

    @Override
    @GetMapping(path = "/user/{id}")
    public StorageDto getStorageById(@PathVariable Long id) {
        return storageService.findById(id);
    }

    @Override
    @GetMapping(path = "/user/")
    public List<StorageDto> getAll() {
        return storageService.findAll();
    }

    @Override
    @GetMapping(path = "/user/exist")
    public List<StorageDto> getAllIfExist() {
        return storageService.getAllByQuantity();
    }

    @Override
    @GetMapping(path = "/user/by-category/{id}")
    public List<StorageDto> getAllByCategory(@PathVariable Long id) {
        return storageService.getAllStorageByCategory(id);
    }

    @Override
    @PostMapping(path = "/admin/add-quantity")
    public void addQuantity(@RequestParam(name = "quantity") int quantity, @RequestParam(name = "id") Long id) {
        storageService.addQuantity(quantity, id);
    }
}
