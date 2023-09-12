package com.hostelmanagmentsystem.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.hostelmanagmentsystem.api.entity.HostelRoomSetup;

@EnableJpaRepositories
public interface HostelRoomSetupRepository extends JpaRepository<HostelRoomSetup, Long> {
    Optional<HostelRoomSetup> findBySchoolId(Long schoolId);
    List<HostelRoomSetup> findByHostelNameAndCategory(String hostelName, String category);
	Optional<HostelRoomSetup> findById(Long schoolId, Integer roomSetupId);
}
