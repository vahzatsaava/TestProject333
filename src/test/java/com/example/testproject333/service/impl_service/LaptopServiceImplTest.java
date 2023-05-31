package com.example.testproject333.service.impl_service;

import com.example.testproject333.model.Laptop;
import com.example.testproject333.model.Monitor;
import com.example.testproject333.repository.LaptopRepository;
import com.example.testproject333.service.LaptopService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class LaptopServiceImplTest {
    @Autowired
    private LaptopService laptopService;
    @MockBean
    private LaptopRepository laptopRepository;

    private Laptop init() {
        Laptop laptop = new Laptop();
        laptop.setId(1L);
        laptop.setSerialNumber("ABC123");
        laptop.setManufacturer("Dell");
        laptop.setPrice(new BigDecimal("999.99"));
        laptop.setQuantity(5);
        laptop.setSize(15);
        return laptop;
    }


    @Test
    public void addMonitor() {
        when(laptopRepository.save(Mockito.any(Laptop.class))).thenReturn(init());
        Assertions.assertEquals(laptopService.addLaptop(init()).getManufacturer(), init().getManufacturer());
    }


    @Test
    public void updateMonitor() {
        when(laptopRepository.save(Mockito.any(Laptop.class))).thenReturn(init());
        when(laptopRepository.findById(anyLong())).thenReturn(Optional.of(init()));
        laptopService.updateLaptop(init(), 1L);
        Mockito.verify(laptopRepository, times(1)).save(init());
        Assertions.assertEquals(laptopService.addLaptop(init()).getManufacturer(), init().getManufacturer());

    }

    @Test
    void getMonitors() {
        when(laptopRepository.findAll()).thenReturn(List.of(init()));
        Assertions.assertEquals(laptopService.getLaptops().get(0).getManufacturer(), init().getManufacturer());

    }

    @Test
    void findById() {
        when(laptopRepository.findById(anyLong())).thenReturn(Optional.of(init()));
        Assertions.assertEquals(laptopService.findById(1L).getManufacturer(), init().getManufacturer());

    }
}