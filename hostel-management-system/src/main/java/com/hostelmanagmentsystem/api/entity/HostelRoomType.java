package com.hostelmanagmentsystem.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "hostel_room_type")
public class HostelRoomType {
    
    @Column(name = "roomTypeId")
    private Integer roomTypeId;

    @Column(name = "roomType")
    private String roomType;
    @Id
    @Column(name = "schoolId")
    private Long schoolId;

}

