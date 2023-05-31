package com.example.testproject333.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HardDriveDto {
    private Long id;
    private String serialNumber;
    private String manufacturer;
    private BigDecimal price;
    private int quantity;
    private int capacity;
}
