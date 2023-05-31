package com.example.testproject333.service.impl_service;

import com.example.testproject333.dto.LaptopDto;
import com.example.testproject333.dto.mapper.LaptopMapper;
import com.example.testproject333.model.Laptop;
import com.example.testproject333.repository.LaptopRepository;
import com.example.testproject333.service.LaptopService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LaptopServiceImpl implements LaptopService {
    private final LaptopRepository laptopRepository;


    @Override
    public LaptopDto addLaptop(Laptop laptop) {
        Laptop laptopCurrent = laptopRepository.save(laptop);
        return LaptopMapper.toLaptopDto(laptopCurrent);
    }

    @Override
    public LaptopDto updateLaptop(Laptop laptop, Long id) {
        Laptop laptopCurrent = laptopRepository.findById(id).orElseThrow();
        laptopCurrent.setSize(laptop.getSize());
        laptopCurrent.setManufacturer(laptop.getManufacturer());
        laptopCurrent.setQuantity(laptop.getQuantity());
        laptopCurrent.setSerialNumber(laptop.getSerialNumber());
        laptopCurrent.setPrice(laptop.getPrice());
        laptopRepository.save(laptopCurrent);
        return LaptopMapper.toLaptopDto(laptopCurrent);
    }

    @Override
    public List<LaptopDto> getLaptops() {
        return laptopRepository.findAll().stream().map(LaptopMapper::toLaptopDto).toList();

    }

    @Override
    public LaptopDto findById(Long id) {
        return LaptopMapper.toLaptopDto(laptopRepository.findById(id).orElseThrow());
    }
}
