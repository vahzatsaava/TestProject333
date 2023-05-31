package com.example.testproject333.service.impl_service;

import com.example.testproject333.model.DesktopComputer;
import com.example.testproject333.model.Laptop;
import com.example.testproject333.repository.DesktopRepository;
import com.example.testproject333.service.DesktopComputerService;
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
class DesktopComputerImplTest {
    @Autowired
    private DesktopComputerService desktopComputerService;
    @MockBean
    private DesktopRepository desktopRepository;

    private DesktopComputer init() {
        DesktopComputer desktop = new DesktopComputer();
        desktop.setId(1L);
        desktop.setSerialNumber("DEF456");
        desktop.setManufacturer("HP");
        desktop.setPrice(new BigDecimal("1499.99"));
        desktop.setQuantity(3);
        desktop.setFormFactor("Tower");

        return desktop;
    }


    @Test
    public void addMonitor() {
        when(desktopRepository.save(Mockito.any(DesktopComputer.class))).thenReturn(init());
        Assertions.assertEquals(desktopComputerService.addDeskComputer(init()).getManufacturer(), init().getManufacturer());
    }


    @Test
    public void updateMonitor() {
        when(desktopRepository.save(Mockito.any(DesktopComputer.class))).thenReturn(init());
        when(desktopRepository.findById(anyLong())).thenReturn(Optional.of(init()));
        desktopComputerService.updateDescComputer(init(), 1L);
        Mockito.verify(desktopRepository, times(1)).save(init());
        Assertions.assertEquals(desktopComputerService.addDeskComputer(init()).getManufacturer(), init().getManufacturer());

    }

    @Test
    void getMonitors() {
        when(desktopRepository.findAll()).thenReturn(List.of(init()));
        Assertions.assertEquals(desktopComputerService.getComputers().get(0).getManufacturer(), init().getManufacturer());

    }

    @Test
    void findById() {
        when(desktopRepository.findById(anyLong())).thenReturn(Optional.of(init()));
        Assertions.assertEquals(desktopComputerService.findById(1L).getManufacturer(), init().getManufacturer());

    }
}