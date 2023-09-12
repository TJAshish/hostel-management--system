package com.hostelmanagmentsystem.api.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hostel_room_setup")
public class HostelRoomSetup {
    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomSetupId;
    
  
    private Long schoolId;
    
    @NotNull
    private String registrationNo;
    @NotNull
    private Integer hostelTypeId;
    @NotEmpty
    private String hostelName;
    @NotEmpty
    private String ownerName;
    @NotEmpty
    private String contactNumber;

    private String capacity;
    @Email
    private String emailId;

    private String monthly;

    private String address;

    private Date createdOn;

    private Date updatedOn;

    private Integer createdBy;

    private Integer updatedBy;
}

