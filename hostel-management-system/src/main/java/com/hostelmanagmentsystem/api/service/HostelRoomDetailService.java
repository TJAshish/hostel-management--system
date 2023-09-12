package com.hostelmanagmentsystem.api.service;

import java.util.List;

import com.hostelmanagmentsystem.api.entity.HostelRoomDetails;

public interface HostelRoomDetailService {

	HostelRoomDetails addRoomDetails (HostelRoomDetails roomDetails,Long schoolId);

    HostelRoomDetails updateRoomDetails(HostelRoomDetails roomDetails,Long schoolId, Integer rooDetailsId);

    HostelRoomDetails getRoomDetailsById(Long schoolId,Integer rooDetailsId);

    List<HostelRoomDetails> getAllRoomDetails(Long schoolId);

//    void deleteRoomDetails(Integer roomSetupId);

}
