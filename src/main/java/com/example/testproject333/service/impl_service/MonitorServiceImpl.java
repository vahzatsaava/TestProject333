package com.example.testproject333.service.impl_service;

import com.example.testproject333.dto.MonitorDto;
import com.example.testproject333.dto.mapper.MonitorMapper;
import com.example.testproject333.model.Monitor;
import com.example.testproject333.repository.MonitorRepository;
import com.example.testproject333.service.MonitorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MonitorServiceImpl implements MonitorService {

    private final MonitorRepository monitorRepository;

    @Override
    public MonitorDto addMonitor(Monitor monitor) {
        Monitor monitorSaved = monitorRepository.save(monitor);
        return MonitorMapper.toMonitorDto(monitorSaved);
    }

    @Override
    public MonitorDto updateMonitor(Monitor monitor, Long id) {
        Monitor monitorCurrent = monitorRepository.findById(id).orElseThrow();
        monitorCurrent.setPrice(monitor.getPrice());
        monitorCurrent.setQuantity(monitor.getQuantity());
        monitorCurrent.setManufacturer(monitor.getManufacturer());
        monitorCurrent.setSerialNumber(monitor.getSerialNumber());
        monitorCurrent.setDiagonal(monitor.getDiagonal());
        monitorRepository.save(monitorCurrent);

        return MonitorMapper.toMonitorDto(monitorCurrent);
    }

    @Override
    public List<MonitorDto> getMonitors() {
        return monitorRepository.findAll().stream().map(MonitorMapper::toMonitorDto).toList();
    }

    @Override
    public MonitorDto findById(Long id) {
        return MonitorMapper.toMonitorDto(monitorRepository.findById(id).orElseThrow());
    }
}
