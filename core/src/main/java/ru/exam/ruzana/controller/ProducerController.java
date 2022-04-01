package ru.exam.ruzana.controller;

import ru.exam.ruzana.dto.ProducerDto;

import java.util.List;

public interface ProducerController {
    void addProducer(ProducerDto producerDto);

    void updateProducer(ProducerDto producerDto);

    void deleteProducer(Long id);

    ProducerDto getProducerById(Long id);

    ProducerDto getProducerByName(String name);

    List<ProducerDto> getAllProducer();
}
