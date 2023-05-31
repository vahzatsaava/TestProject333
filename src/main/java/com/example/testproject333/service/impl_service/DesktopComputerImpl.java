package com.example.testproject333.service.impl_service;

import com.example.testproject333.dto.DesktopComputerDto;
import com.example.testproject333.dto.mapper.DesktopComputerMapper;
import com.example.testproject333.model.DesktopComputer;
import com.example.testproject333.repository.DesktopRepository;
import com.example.testproject333.service.DesktopComputerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DesktopComputerImpl implements DesktopComputerService {
    private final DesktopRepository desktopRepository;

    @Override
    public DesktopComputerDto addDeskComputer(DesktopComputer desktopComputer) {
        DesktopComputer desktopComputerCurrent = desktopRepository.save(desktopComputer);
        return DesktopComputerMapper.toDeskTopComputerDto(desktopComputerCurrent);
    }

    @Override
    public DesktopComputerDto updateDescComputer(DesktopComputer desktopComputers, Long id) {
        DesktopComputer desktopCurrents = desktopRepository.findById(id).orElseThrow();
        desktopCurrents.setFormFactor(desktopComputers.getFormFactor());
        desktopCurrents.setManufacturer(desktopComputers.getManufacturer());
        desktopCurrents.setQuantity(desktopComputers.getQuantity());
        desktopCurrents.setSerialNumber(desktopComputers.getSerialNumber());
        desktopCurrents.setPrice(desktopComputers.getPrice());
        desktopRepository.save(desktopCurrents);

        return DesktopComputerMapper.toDeskTopComputerDto(desktopComputers);
    }

    @Override
    public List<DesktopComputerDto> getComputers() {
        return desktopRepository.findAll().stream().map(DesktopComputerMapper::toDeskTopComputerDto).collect(Collectors.toList());
    }

    @Override
    public DesktopComputerDto findById(Long id) {
        return DesktopComputerMapper.toDeskTopComputerDto(desktopRepository.findById(id).orElseThrow());
    }
}
