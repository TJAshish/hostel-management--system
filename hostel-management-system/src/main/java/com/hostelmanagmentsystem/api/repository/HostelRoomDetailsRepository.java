package com.hostelmanagmentsystem.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hostelmanagmentsystem.api.entity.HostelRoomDetails;

public interface HostelRoomDetailsRepository extends JpaRepository<HostelRoomDetails,Integer> {

	Optional<HostelRoomDetails> findByRoomSetupId(Integer roomSetupId);
	
}
