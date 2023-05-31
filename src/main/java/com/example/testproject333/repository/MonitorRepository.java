package com.example.testproject333.repository;

import com.example.testproject333.dto.MonitorDto;
import com.example.testproject333.model.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitorRepository extends JpaRepository<Monitor,Long> {

}
