package com.example.testproject333.controller;

import com.example.testproject333.dto.DesktopComputerDto;
import com.example.testproject333.model.DesktopComputer;
import com.example.testproject333.service.DesktopComputerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/v1/desktops")
public class DesctopComputerController {
    private final DesktopComputerService service;

    @PostMapping("/add")
    public ResponseEntity<DesktopComputerDto> createStudentByMentor(@RequestBody DesktopComputer desktopComputer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addDeskComputer(desktopComputer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DesktopComputerDto> getById(@PathVariable("id") Long id) {
       DesktopComputerDto current = service.findById(id);
        return new ResponseEntity<>(current, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<DesktopComputerDto>> getAll() {
        return new ResponseEntity<>(service.getComputers(), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<DesktopComputerDto> update(@RequestBody DesktopComputer desktopComputer, @PathVariable Long id) {

        return new ResponseEntity<>(service.updateDescComputer(desktopComputer,id), HttpStatus.OK);
    }
}
