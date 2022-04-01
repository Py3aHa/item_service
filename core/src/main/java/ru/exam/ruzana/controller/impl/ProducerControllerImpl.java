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
import ru.exam.ruzana.controller.ProducerController;
import ru.exam.ruzana.dto.ProducerDto;
import ru.exam.ruzana.service.ProducerService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/producer")
public class ProducerControllerImpl implements ProducerController {
    @Autowired
    private ProducerService producerService;

    @Override
    @PostMapping(path = "/admin/")
    public void addProducer(@RequestBody ProducerDto producerDto) {
        producerService.save(producerDto);
    }

    @Override
    @PatchMapping(path = "/admin/")
    public void updateProducer(@RequestBody ProducerDto producerDto) {
        producerService.update(producerDto);
    }

    @Override
    @DeleteMapping(path = "/admin/{id}")
    public void deleteProducer(@PathVariable Long id) {
        producerService.delete(id);
    }

    @Override
    @GetMapping(path = "/user/{id}")
    public ProducerDto getProducerById(@PathVariable Long id) {
        return producerService.findById(id);
    }

    @Override
    @GetMapping(path = "/user/by-name")
    public ProducerDto getProducerByName(@RequestParam(name = "name") String name) {
        return producerService.findProducerByName(name);
    }

    @Override
    @GetMapping(path = "/user/")
    public List<ProducerDto> getAllProducer() {
        return producerService.findAll();
    }
}
