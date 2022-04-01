package ru.exam.ruzana.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StorageDto {
    private String name;

    private int quantity;

    private int pricePerUnit;

    private String producerId;

    private Long categoryId;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
