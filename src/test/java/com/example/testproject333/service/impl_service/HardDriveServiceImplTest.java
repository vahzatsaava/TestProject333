package com.example.testproject333.service.impl_service;

import com.example.testproject333.model.HardDrive;
import com.example.testproject333.model.Laptop;
import com.example.testproject333.repository.HardDriverRepository;
import com.example.testproject333.service.HardDriverService;
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
class HardDriveServiceImplTest {
    @Autowired
    private HardDriverService hardDriverService;
    @MockBean
    private HardDriverRepository driverRepository;

    private HardDrive init() {
        HardDrive hardDrive = new HardDrive();
        hardDrive.setId(1L);
        hardDrive.setSerialNumber("HDD123");
        hardDrive.setManufacturer("Seagate");
        hardDrive.setPrice(new BigDecimal("99.99"));
        hardDrive.setQuantity(5);
        hardDrive.setCapacity(1000);

        return hardDrive;
    }


    @Test
    public void addMonitor() {
        when(driverRepository.save(Mockito.any(HardDrive.class))).thenReturn(init());
        Assertions.assertEquals(hardDriverService.addDrive(init()).getManufacturer(), init().getManufacturer());
    }


    @Test
    public void updateMonitor() {
        when(driverRepository.save(Mockito.any(HardDrive.class))).thenReturn(init());
        when(driverRepository.findById(anyLong())).thenReturn(Optional.of(init()));
        hardDriverService.updateDrive(init(), 1L);
        Mockito.verify(driverRepository, times(1)).save(init());
        Assertions.assertEquals(hardDriverService.addDrive(init()).getManufacturer(), init().getManufacturer());

    }

    @Test
    void getMonitors() {
        when(driverRepository.findAll()).thenReturn(List.of(init()));
        Assertions.assertEquals(hardDriverService.getHardDrives().get(0).getManufacturer(), init().getManufacturer());

    }

    @Test
    void findById() {
        when(driverRepository.findById(anyLong())).thenReturn(Optional.of(init()));
        Assertions.assertEquals(hardDriverService.findById(1L).getManufacturer(), init().getManufacturer());

    }
}