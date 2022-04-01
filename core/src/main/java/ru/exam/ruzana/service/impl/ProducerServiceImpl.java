package ru.exam.ruzana.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.exam.ruzana.dto.ProducerDto;
import ru.exam.ruzana.model.Producer;
import ru.exam.ruzana.repository.ProducerRepository;
import ru.exam.ruzana.service.ProducerService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProducerServiceImpl implements ProducerService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProducerRepository producerRepository;

    @Override
    public void save(ProducerDto object) {
        Producer producer = modelMapper.map(object, Producer.class);
        producerRepository.insert(producer);
    }

    @Override
    public ProducerDto findById(Long id) {
        Producer producer = producerRepository.findById(id);
        return modelMapper.map(producer, ProducerDto.class);
    }

    @Override
    public List<ProducerDto> findAll() {
        List<Producer> producers = producerRepository.findAll();
        List<ProducerDto> producerDtos = producers.stream()
                .map(item -> modelMapper.map(item, ProducerDto.class))
                .collect(Collectors.toList());
        return producerDtos;
    }

    @Override
    public void update(ProducerDto object) {
        Producer producer = modelMapper.map(object, Producer.class);
        producerRepository.update(producer);
    }

    @Override
    public void delete(Long id) {
        producerRepository.delete(id);
    }

    @Override
    public ProducerDto findProducerByName(String name) {
        Producer producer = producerRepository.findByName(name);
        return modelMapper.map(producer, ProducerDto.class);
    }
}
