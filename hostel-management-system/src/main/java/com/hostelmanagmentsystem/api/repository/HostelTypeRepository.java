package com.hostelmanagmentsystem.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hostelmanagmentsystem.api.entity.HostelType;


public interface HostelTypeRepository extends JpaRepository<HostelType, Integer> {
    
}

