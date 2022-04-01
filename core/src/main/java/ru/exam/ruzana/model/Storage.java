package ru.exam.ruzana.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {
    private Long id;

    private String name;

    private int quantity;

    private int pricePerUnit;

    private Long producerId;

    private Long categoryId;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
