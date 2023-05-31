package com.example.testproject333.dto.mapper;

import com.example.testproject333.dto.LaptopDto;
import com.example.testproject333.model.Laptop;

public class LaptopMapper {
    public static LaptopDto toLaptopDto(Laptop laptop) {
        LaptopDto laptopDto = new LaptopDto();
        laptopDto.setId(laptop.getId());
        laptopDto.setSize(laptop.getSize());
        laptopDto.setManufacturer(laptop.getManufacturer());
        laptopDto.setQuantity(laptop.getQuantity());
        laptopDto.setSerialNumber(laptop.getSerialNumber());
        laptopDto.setPrice(laptop.getPrice());
        return laptopDto;
    }
}
