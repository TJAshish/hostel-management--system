package com.hostelmanagmentsystem.api.serviceImpl;

import java.lang.reflect.Field;
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
        hostelRoomSetup.setCreatedOn(new Date());
        return hostelRoomSetupRepository.save(hostelRoomSetup);
    }


    @Override
    public HostelRoomSetup updateHostel(HostelRoomSetup hostelRoomSetup, Integer roomSetupId) {
        HostelRoomSetup hostel = this.hostelRoomSetupRepository.findByroomSetupId(roomSetupId)
                .orElseThrow(() -> new ResourceNotFoundException("Hostel room Setup", "id", roomSetupId));

        Field[] fields = HostelRoomSetup.class.getDeclaredFields();

        for (Field field : fields) {
            try {
                // Set the field to be accessible (even if it's private)
                field.setAccessible(true);

                // Get the value of the field from roomDetails
                Object fieldValue = field.get(hostelRoomSetup);

                // If the field value is not null, update it in details
                if (fieldValue != null) {
                    field.set(hostel, fieldValue);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                throw new RuntimeException("Error updating hostel fields.");
            }
        }

        HostelRoomSetup updated = this.hostelRoomSetupRepository.save(hostel);
        return updated;
    }

    @Override
    public HostelRoomSetup getHostelById(Integer roomSetupId) {
        return this.hostelRoomSetupRepository.findByroomSetupId(roomSetupId)
                .orElseThrow(() -> new ResourceNotFoundException("Hostel Room setup", "id", roomSetupId));
    }

    @Override
    public List<HostelRoomSetup> getAllHostels() {
        return hostelRoomSetupRepository.findAll();
    }

    public void deleteHostel(Integer roomSetupId) {
        HostelRoomSetup delete = this.hostelRoomSetupRepository.findById(roomSetupId)
                .orElseThrow(() -> new ResourceNotFoundException("Hostel room setup", "Id ", roomSetupId));
        this.hostelRoomSetupRepository.delete(delete);
    }
}
