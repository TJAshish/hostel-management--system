package com.hostelmanagmentsystem.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hostel_room_details")
public class HostelRoomDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomDetailsId;
    
    private Long schoolId;
    
    
    @NotNull
    private Integer roomSetupId;
    
    @NotNull
    private Integer hostelTypeId;
    
    @NotNull
    private Integer hostelNameId;
    
    @NotNull
    private Integer category;
    
    @NotNull
    private Integer roomTypeId;
    
    @NotNull
    private Integer noOfBed;
    
    private Integer fair;
    
}

