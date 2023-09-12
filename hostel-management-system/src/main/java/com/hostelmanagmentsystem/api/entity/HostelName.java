package com.hostelmanagmentsystem.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hostel_name")
public class HostelName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hostelNametId")
    private Integer hostelNametId;

    @Column(name = "hostelName")
    private String hostelName;

    @Column(name = "schoolId")
    private Long schoolId;

}

