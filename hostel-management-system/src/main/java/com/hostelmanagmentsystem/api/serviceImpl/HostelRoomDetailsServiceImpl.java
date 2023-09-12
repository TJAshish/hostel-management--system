package com.hostelmanagmentsystem.api.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostelmanagmentsystem.api.entity.HostelRoomDetails;
import com.hostelmanagmentsystem.api.exceptions.ResourceNotFoundException;
import com.hostelmanagmentsystem.api.repository.HostelRoomDetailsRepository;
import com.hostelmanagmentsystem.api.service.HostelRoomDetailService;
@Service
public class HostelRoomDetailsServiceImpl implements HostelRoomDetailService {

	@Autowired
	HostelRoomDetailsRepository roomDetailsRepository;
	
	 @Override
	    public HostelRoomDetails addRoomDetails(HostelRoomDetails roomDetails) {
	        return roomDetailsRepository.save(roomDetails);
	    }

	    @Override
	    public HostelRoomDetails updateRoomDetails(HostelRoomDetails roomDetails, Integer roomSetupId) {
	        Optional<HostelRoomDetails> details = this.roomDetailsRepository.findById(roomSetupId);
	        if (details.isPresent()) {
	            HostelRoomDetails updatedRoomDetails = details.get();
	            // Update the properties of the existing room details with the new values
	            updatedRoomDetails.setHostelType(roomDetails.getHostelType());
	            updatedRoomDetails.setHostelName(roomDetails.getHostelName());
	            updatedRoomDetails.setCategory(roomDetails.getCategory());
	            updatedRoomDetails.setRoomType(roomDetails.getRoomType());
	            updatedRoomDetails.setNoOfBed(roomDetails.getNoOfBed());
	            updatedRoomDetails.setFair(roomDetails.getFair());

	            return roomDetailsRepository.save(updatedRoomDetails);
	        } else {
	            // Handle the case where the room details with the given ID does not exist
	            throw new RuntimeException("Room details with ID " + roomSetupId + " not found");
	        }
	    }

	    @Override
	    public HostelRoomDetails getRoomDetailsById(Integer roomSetupId) {
	        Optional<HostelRoomDetails> roomDetails = roomDetailsRepository.findById(roomSetupId);
	        return roomDetails.orElseThrow(()->new ResourceNotFoundException("Hostel Details", "Room setup id", roomSetupId));
	    }

	    @Override
	    public List<HostelRoomDetails> getAllRoomDetails() {
	        return roomDetailsRepository.findAll();
	    }

	    @Override
	    public void deleteRoomDetails(Integer roomSetupId) {
	    	this.roomDetailsRepository.findByRoomSetupId(roomSetupId).orElseThrow(()->new ResourceNotFoundException("Hostel Details", "Room setup id", roomSetupId));
	        roomDetailsRepository.deleteById(roomSetupId);
	    }

}
