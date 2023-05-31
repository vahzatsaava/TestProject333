package com.example.testproject333.controller;

import com.example.testproject333.dto.MonitorDto;
import com.example.testproject333.model.Monitor;
import com.example.testproject333.service.MonitorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/v1/monitors")
public class MonitorController {
    private final MonitorService monitorService;

    @PostMapping("/add")
    public ResponseEntity<MonitorDto> createStudentByMentor(@RequestBody Monitor monitor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(monitorService.addMonitor(monitor));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MonitorDto> getById(@PathVariable("id") Long id) {
        MonitorDto current = monitorService.findById(id);
        return new ResponseEntity<>(current, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<MonitorDto>> getAll() {
        return new ResponseEntity<>(monitorService.getMonitors(), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<MonitorDto> update(@RequestBody Monitor monitor, @PathVariable Long id) {

        return new ResponseEntity<>(monitorService.updateMonitor(monitor,id), HttpStatus.OK);
    }
}
