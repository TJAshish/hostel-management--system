package com.hostelmanagmentsystem.api.service;

import java.util.List;

import com.hostelmanagmentsystem.api.entity.HostelRoomDetails;

public interface HostelRoomDetailService {

	HostelRoomDetails addRoomDetails (HostelRoomDetails roomDetails);

    HostelRoomDetails updateRoomDetails(HostelRoomDetails roomDetails, Integer roomSetupId);

    HostelRoomDetails getRoomDetailsById(Integer roomSetupId);

    List<HostelRoomDetails> getAllRoomDetails();

    void deleteRoomDetails(Integer roomSetupId);
}
