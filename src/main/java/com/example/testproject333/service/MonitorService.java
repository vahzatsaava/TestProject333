package com.example.testproject333.service;

import com.example.testproject333.dto.MonitorDto;
import com.example.testproject333.model.Monitor;

import java.util.List;

public interface MonitorService {
    MonitorDto addMonitor(Monitor monitor);

    MonitorDto updateMonitor(Monitor monitor, Long id);

    List<MonitorDto> getMonitors();

    MonitorDto findById(Long id);

}
