package com.example.testproject333.service;

import com.example.testproject333.dto.HardDriveDto;
import com.example.testproject333.model.HardDrive;

import java.util.List;

public interface HardDriverService {
    HardDriveDto addDrive(HardDrive hardDrive);

    HardDriveDto updateDrive(HardDrive hardDrive, Long id);

    List<HardDriveDto> getHardDrives();

    HardDriveDto findById(Long id);
}
