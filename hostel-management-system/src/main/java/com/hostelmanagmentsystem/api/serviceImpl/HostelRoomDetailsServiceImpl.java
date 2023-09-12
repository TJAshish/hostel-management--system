package com.hostelmanagmentsystem.api.serviceImpl; 

 
import java.util.List; 
import java.util.Map;
import java.lang.reflect.Field;
import java.util.HashMap;
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
	private HostelRoomDetailsRepository roomDetailsRepository;
	
	 @Override
	 public HostelRoomDetails addRoomDetails(HostelRoomDetails roomDetails, Long schoolId) {
		 
		 	roomDetails.setSchoolId(schoolId);
	        return roomDetailsRepository.save(roomDetails);
	    }

	    @Override
	    public HostelRoomDetails updateRoomDetails(HostelRoomDetails roomDetails,Long schoolId, Integer roomSetupId) {
	        HostelRoomDetails details = this.roomDetailsRepository.findBySchoolIdAndRoomDetailsId(schoolId, roomSetupId).orElseThrow(()->new ResourceNotFoundException("Hostel Room Detail ","schoolId / room setup id",schoolId, roomSetupId));
//	        details.setRoomSetupId(roomDetails.getRoomSetupId());
//	        details.setHostelNameId(roomDetails.getHostelNameId());
//	        details.setHostelTypeId(roomDetails.getHostelTypeId());
//	        details.setCategory(roomDetails.getCategory());
//	        details.setRoomTypeId(roomDetails.getRoomTypeId());
//	        details.setNoOfBed(roomDetails.getNoOfBed());
//	        details.setFair(roomDetails.getFair());
	        Map<String, Object> fieldUpdates = new HashMap<>();

	        Field[] fields = HostelRoomDetails.class.getDeclaredFields();

	        for (Field field : fields) {
	            try {
	                // Set the field to be accessible (even if it's private)
	                field.setAccessible(true);

	                // Get the value of the field from roomDetails
	                Object fieldValue = field.get(roomDetails);

	                // If the field value is not null, update it in details
	                if (fieldValue != null) {
	                    field.set(details, fieldValue);
	                }
	            } catch (IllegalAccessException e) {
	                e.printStackTrace(); 
	            }
	        }	       
	        HostelRoomDetails updateDetais = this.roomDetailsRepository.save(details);
	        return updateDetais;
	    }
	    @Override
	    public HostelRoomDetails getRoomDetailsById(Long schoolId,Integer roomSetupId) {
	        HostelRoomDetails roomDetails = roomDetailsRepository.findBySchoolIdAndRoomDetailsId(schoolId, roomSetupId).orElseThrow(()->new ResourceNotFoundException("Hostel Details", "school id/Room setup id",schoolId, roomSetupId));
	        return roomDetails;
	    }

	    @Override
	    public List<HostelRoomDetails> getAllRoomDetails(Long schoolId){
	    		return this.roomDetailsRepository.findAllBySchoolId(schoolId);
	    }

}
