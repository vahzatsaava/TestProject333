package com.example.testproject333.model;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("laptop")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Laptop extends Product {
    private int size;
}
