package com.example.testproject333.service;

import com.example.testproject333.dto.DesktopComputerDto;
import com.example.testproject333.model.DesktopComputer;

import java.util.List;

public interface DesktopComputerService  {
    DesktopComputerDto addDeskComputer(DesktopComputer desktopComputer);

    DesktopComputerDto updateDescComputer(DesktopComputer desktopComputer, Long id);

    List<DesktopComputerDto> getComputers();

    DesktopComputerDto findById(Long id);
}
