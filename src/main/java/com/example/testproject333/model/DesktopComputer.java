package com.example.testproject333.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("desktop")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DesktopComputer extends Product {
    private String formFactor;
}
