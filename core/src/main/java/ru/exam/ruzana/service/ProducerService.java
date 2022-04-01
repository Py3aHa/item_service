package ru.exam.ruzana.service;

import ru.exam.ruzana.dto.ProducerDto;

public interface ProducerService extends BasicCRUDService<ProducerDto> {
    ProducerDto findProducerByName(String name);
}
