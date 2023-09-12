package com.hostelmanagmentsystem.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hostel_category")
public class HostelCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hostelCatId;

    private String category;

    private Long schoolId;

}

