package com.hostelmanagmentsystem.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import com.hostelmanagmentsystem.api.entity.HostelRoomDetails;

@EnableJpaRepositories
public interface HostelRoomDetailsRepository extends JpaRepository<HostelRoomDetails,Integer> {
	 	
	@Query("SELECT h FROM HostelRoomDetails h WHERE h.schoolId = :sId AND h.roomDetailsId = :detailsId")
	Optional<HostelRoomDetails> findBySchoolIdAndRoomDetailsId(
			@Param("sId") Long schoolId,
			@Param("detailsId") Integer roomDetailsId
			);
	@Query("SELECT h FROM HostelRoomDetails h WHERE h.schoolId = :sId")
	List<HostelRoomDetails> findAllBySchoolId(@Param("sId") Long schoolId);
	
	
}
