package com.example.testproject333.model;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("hard_drive")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class HardDrive extends Product {
    private int capacity;
}
