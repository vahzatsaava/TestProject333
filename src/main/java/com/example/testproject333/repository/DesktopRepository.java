package com.example.testproject333.repository;

import com.example.testproject333.model.DesktopComputer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesktopRepository extends JpaRepository<DesktopComputer,Long> {
}
