package com.hostelmanagmentsystem.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.hostelmanagmentsystem.api.entity.HostelRoomSetup;

@EnableJpaRepositories
public interface HostelRoomSetupRepository extends JpaRepository<HostelRoomSetup, Integer> {
	Optional<HostelRoomSetup> findByroomSetupId(Integer roomSetupId);
}


