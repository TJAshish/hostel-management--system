package com.hostelmanagmentsystem.api.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostelmanagmentsystem.api.entity.HostelRoomSetup;
import com.hostelmanagmentsystem.api.exceptions.ResourceNotFoundException;
import com.hostelmanagmentsystem.api.repository.HostelRoomSetupRepository;
import com.hostelmanagmentsystem.api.service.HostelRoomSetupService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class HostelRoomSetupServiceImpl implements HostelRoomSetupService {
	
	@Autowired
	private HostelRoomSetupRepository hostelRoomSetupRepository;


    @Override
    public HostelRoomSetup addHostel(HostelRoomSetup hostelRoomSetup) {
        // Set the created date and any other necessary properties
        hostelRoomSetup.setCreatedOn(new Date());
        // You can set other properties as needed before saving
        return hostelRoomSetupRepository.save(hostelRoomSetup);
    }

    @Override
    public HostelRoomSetup updateHostel(HostelRoomSetup hostelRoomSetup, Long schoolId) {
        Optional<HostelRoomSetup> existingHostel = hostelRoomSetupRepository.findById(schoolId);
        if (existingHostel.isPresent()) {
            HostelRoomSetup updatedHostel = existingHostel.get();
            updatedHostel.setHostelName(hostelRoomSetup.getHostelName());
            updatedHostel.setOwnerName(hostelRoomSetup.getOwnerName());
            updatedHostel.setContactNumber(hostelRoomSetup.getContactNumber());
            updatedHostel.setUpdatedOn(new Date());

            return hostelRoomSetupRepository.save(updatedHostel);
        } else {
            throw new RuntimeException("Hostel with ID " + schoolId + " not found");
        }
    }

    @Override
    public HostelRoomSetup getHostelById(Long schoolId) {
        Optional<HostelRoomSetup> hostel = hostelRoomSetupRepository.findById(schoolId);
        return hostel.orElseThrow(()-> new ResourceNotFoundException("Hostel Room Setup", "Id", schoolId));
    }

    @Override
    public List<HostelRoomSetup> getAllHostels() {
        return hostelRoomSetupRepository.findAll();
    }

    @Override
    public void deleteHostel(Long schoolId) {
    	HostelRoomSetup delete = this.hostelRoomSetupRepository.findById(schoolId).orElseThrow(()->new ResourceNotFoundException("Hostel room setup", "School id", schoolId));
        this.hostelRoomSetupRepository.delete(delete);
    }
}
