package com.hostelmanagmentsystem.api.service;

import java.util.List;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.hostelmanagmentsystem.api.entity.HostelRoomSetup;

@EnableJpaRepositories
public interface HostelRoomSetupService {
	
	
	HostelRoomSetup addHostel(HostelRoomSetup hostelRoomSetup);
	HostelRoomSetup updateHostel(HostelRoomSetup hostelRoomSetup,Integer roomSetupId);
	HostelRoomSetup getHostelById(Integer roomSetupId);
	List<HostelRoomSetup> getAllHostels();
	
	void deleteHostel(Integer roomSetupId);
}
