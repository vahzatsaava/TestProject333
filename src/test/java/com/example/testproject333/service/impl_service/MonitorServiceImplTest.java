package com.example.testproject333.service.impl_service;

import com.example.testproject333.dto.MonitorDto;
import com.example.testproject333.model.Monitor;
import com.example.testproject333.repository.MonitorRepository;
import com.example.testproject333.service.MonitorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
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

import static net.bytebuddy.matcher.ElementMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class MonitorServiceImplTest {
    @Autowired
    private MonitorService monitorService;
    @MockBean
    private MonitorRepository monitorRepository;

    private Monitor init() {
        Monitor monitor = new Monitor();
        monitor.setDiagonal(27.0);
        monitor.setSerialNumber("ABC123");
        monitor.setManufacturer("Samsung");
        monitor.setPrice(new BigDecimal("249.99"));
        monitor.setQuantity(10);
        return monitor;
    }


    @Test
    public void addMonitor() {
        when(monitorRepository.save(Mockito.any(Monitor.class))).thenReturn(init());
        Assertions.assertEquals(monitorService.addMonitor(init()).getDiagonal(),init().getDiagonal());
    }


    @Test
    public void updateMonitor() {
        when(monitorRepository.save(Mockito.any(Monitor.class))).thenReturn(init());
        when(monitorRepository.findById(anyLong())).thenReturn(Optional.of(init()));
        monitorService.updateMonitor(init(),1L);
        Mockito.verify(monitorRepository,times(1)).save(init());
        Assertions.assertEquals(monitorService.addMonitor(init()).getDiagonal(),init().getDiagonal());

    }

    @Test
    void getMonitors() {
        when(monitorRepository.findAll()).thenReturn(List.of(init()));
        Assertions.assertEquals(monitorService.getMonitors().get(0).getManufacturer(),init().getManufacturer());

    }

    @Test
    void findById() {
        when(monitorRepository.findById(anyLong())).thenReturn(Optional.of(init()));
        Assertions.assertEquals(monitorService.findById(1L).getManufacturer(),init().getManufacturer());

    }
}