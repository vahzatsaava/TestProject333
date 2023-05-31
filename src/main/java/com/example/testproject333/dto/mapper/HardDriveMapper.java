package com.example.testproject333.dto.mapper;

import com.example.testproject333.dto.HardDriveDto;
import com.example.testproject333.model.HardDrive;

public class HardDriveMapper {
    public static HardDriveDto toHardDriveDto(HardDrive hardDrive) {
        HardDriveDto hardDriveDto = new HardDriveDto();
        hardDriveDto.setId(hardDrive.getId());
        hardDriveDto.setCapacity(hardDrive.getCapacity());
        hardDriveDto.setManufacturer(hardDrive.getManufacturer());
        hardDriveDto.setQuantity(hardDrive.getQuantity());
        hardDriveDto.setSerialNumber(hardDrive.getSerialNumber());
        hardDriveDto.setPrice(hardDrive.getPrice());
        return hardDriveDto;
    }

}
