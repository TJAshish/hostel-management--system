package com.hostelmanagmentsystem.api.entity;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
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
@Table(name = "hostel_room_setup")
public class HostelRoomSetup implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id    
    @Column(name = "schoolId")
    private Long schoolId;
    
    @NotNull
    @Column(name = "registrationNo")
    private String registrationNo;
    @NotNull
    @Column(name = "hostelTypeId")
    private Integer hostelTypeId;
    @NotEmpty
    @Column(name = "hostelName")
    private String hostelName;
    @NotEmpty
    @Column(name = "ownerName")
    private String ownerName;
    @NotEmpty
    @Column(name = "contactNumber")
    private String contactNumber;

    @Column(name = "capacity")
    private String capacity;
    @Email
    @Column(name = "emailId")
    private String emailId;

    @Column(name = "monthly")
    private String monthly;

    @Column(name = "address")
    private String address;


    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "updated_on")
    private Date updatedOn;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "updated_by")
    private Integer updatedBy;

}

