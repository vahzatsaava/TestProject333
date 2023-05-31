package com.example.testproject333.service;

import com.example.testproject333.dto.LaptopDto;
import com.example.testproject333.model.Laptop;

import java.util.List;

public interface LaptopService {
    LaptopDto addLaptop(Laptop laptop);

    LaptopDto updateLaptop(Laptop laptop, Long id);

    List<LaptopDto> getLaptops();

    LaptopDto findById(Long id);
}
