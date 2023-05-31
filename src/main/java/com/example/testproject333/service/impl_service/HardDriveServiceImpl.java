package com.example.testproject333.service.impl_service;

import com.example.testproject333.dto.HardDriveDto;
import com.example.testproject333.dto.mapper.HardDriveMapper;
import com.example.testproject333.model.HardDrive;
import com.example.testproject333.repository.HardDriverRepository;
import com.example.testproject333.service.HardDriverService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class HardDriveServiceImpl implements HardDriverService {
    private final HardDriverRepository hardDriverRepository;


    @Override
    public HardDriveDto addDrive(HardDrive hardDrive) {
        HardDrive saved = hardDriverRepository.save(hardDrive);
        return HardDriveMapper.toHardDriveDto(saved);
    }

    @Override
    public HardDriveDto updateDrive(HardDrive hardDrive, Long id) {
        HardDrive monitorCurrents = hardDriverRepository.findById(id).orElseThrow();
        monitorCurrents.setCapacity(hardDrive.getCapacity());
        monitorCurrents.setManufacturer(hardDrive.getManufacturer());
        monitorCurrents.setQuantity(hardDrive.getQuantity());
        monitorCurrents.setSerialNumber(hardDrive.getSerialNumber());
        monitorCurrents.setPrice(hardDrive.getPrice());
        hardDriverRepository.save(monitorCurrents);

        return HardDriveMapper.toHardDriveDto(monitorCurrents);
    }

    @Override
    public List<HardDriveDto> getHardDrives() {
        return hardDriverRepository.findAll().stream().map(HardDriveMapper::toHardDriveDto).collect(Collectors.toList());
    }

    @Override
    public HardDriveDto findById(Long id) {
        return HardDriveMapper.toHardDriveDto(hardDriverRepository.findById(id).orElseThrow());
    }
}
