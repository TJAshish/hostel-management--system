package com.hostelmanagmentsystem.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hostel_room_details")
public class HostelRoomDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roomSetupId")
    private Integer roomSetupId;
    
    @NotNull
    @Column(name = "Hostel_Type")
    private Integer hostelType;
    
    @NotNull
    @Column(name = "Hostel_Name")
    private Integer hostelName;
    
    @NotNull
    @Column(name = "Category")
    private Integer category;
    
    @NotNull
    @Column(name = "Room_Type")
    private Integer roomType;
    
    @NotNull
    @Column(name = "No_Of_Bed")
    private Integer noOfBed;
    
    @Column(name = "Fair")
    private Integer fair;
    
    @Column(name = "schoolId")
    private Long schoolId;
}

