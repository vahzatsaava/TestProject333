package com.example.testproject333.controller;

import com.example.testproject333.dto.LaptopDto;
import com.example.testproject333.model.Laptop;
import com.example.testproject333.service.LaptopService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/v1/laptops")
public class LaptopController {
    private final LaptopService laptopService;

    @PostMapping("/add")
    public ResponseEntity<LaptopDto> createStudentByMentor(@RequestBody Laptop laptop) {
        return ResponseEntity.status(HttpStatus.CREATED).body(laptopService.addLaptop(laptop));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LaptopDto> getById(@PathVariable("id") Long id) {
        LaptopDto current = laptopService.findById(id);
        return new ResponseEntity<>(current, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<LaptopDto>> getAll() {
        return new ResponseEntity<>(laptopService.getLaptops(), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<LaptopDto> update(@RequestBody Laptop laptop, @PathVariable Long id) {

        return new ResponseEntity<>(laptopService.updateLaptop(laptop,id), HttpStatus.OK);
    }
}
