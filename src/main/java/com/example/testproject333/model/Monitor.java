package com.example.testproject333.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("monitor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Monitor extends Product {
    private double diagonal;
}
