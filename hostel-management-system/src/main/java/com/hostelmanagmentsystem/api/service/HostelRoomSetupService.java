package com.hostelmanagmentsystem.api.service;

import java.util.List;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.hostelmanagmentsystem.api.entity.HostelRoomSetup;

@EnableJpaRepositories
public interface HostelRoomSetupService {
	
	
	HostelRoomSetup addHostel(HostelRoomSetup hostelRoomSetup);
	HostelRoomSetup updateHostel(HostelRoomSetup hostelRoomSetup,Long schoolId);
	HostelRoomSetup getHostelById(Long schoolId);
	List<HostelRoomSetup> getAllHostels();
	
	void deleteHostel(Long schoolId);
}
