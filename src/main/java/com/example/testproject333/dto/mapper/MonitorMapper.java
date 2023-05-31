package com.example.testproject333.dto.mapper;

import com.example.testproject333.dto.MonitorDto;
import com.example.testproject333.model.Monitor;

public class MonitorMapper {
    public static MonitorDto toMonitorDto(Monitor monitor) {
        MonitorDto monitorDto = new MonitorDto();
        monitorDto.setId(monitor.getId());
        monitorDto.setDiagonal(monitor.getDiagonal());
        monitorDto.setManufacturer(monitor.getManufacturer());
        monitorDto.setQuantity(monitor.getQuantity());
        monitorDto.setSerialNumber(monitor.getSerialNumber());
        monitorDto.setPrice(monitor.getPrice());
        return monitorDto;
    }

}
