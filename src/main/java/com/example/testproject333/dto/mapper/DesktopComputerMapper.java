package com.example.testproject333.dto.mapper;

import com.example.testproject333.dto.DesktopComputerDto;
import com.example.testproject333.model.DesktopComputer;

public class DesktopComputerMapper {
    public static DesktopComputerDto toDeskTopComputerDto(DesktopComputer desktopComputer) {
        DesktopComputerDto desktopComputerDto = new DesktopComputerDto();
        desktopComputerDto.setId(desktopComputer.getId());
        desktopComputerDto.setFormFactor(desktopComputer.getFormFactor());
        desktopComputerDto.setManufacturer(desktopComputer.getManufacturer());
        desktopComputerDto.setQuantity(desktopComputer.getQuantity());
        desktopComputerDto.setSerialNumber(desktopComputer.getSerialNumber());
        desktopComputerDto.setPrice(desktopComputer.getPrice());
        return desktopComputerDto;
    }
}
