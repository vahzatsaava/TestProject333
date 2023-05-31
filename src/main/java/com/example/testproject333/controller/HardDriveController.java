package com.example.testproject333.controller;

import com.example.testproject333.dto.HardDriveDto;
import com.example.testproject333.model.HardDrive;
import com.example.testproject333.service.HardDriverService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/v1/drives")
public class HardDriveController {
    private final HardDriverService service;

    @PostMapping("/add")
    public ResponseEntity<HardDriveDto> createStudentByMentor(@RequestBody HardDrive hardDrive) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addDrive(hardDrive));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HardDriveDto> getById(@PathVariable("id") Long id) {
        HardDriveDto current = service.findById(id);
        return new ResponseEntity<>(current, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<HardDriveDto>> getAll() {
        return new ResponseEntity<>(service.getHardDrives(), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<HardDriveDto> update(@RequestBody HardDrive hardDrive, @PathVariable Long id) {
        return new ResponseEntity<>(service.updateDrive(hardDrive, id), HttpStatus.OK);
    }
}
