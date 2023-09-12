package com.hostelmanagmentsystem.api.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostelmanagmentsystem.api.entity.HostelRoomDetails;
import com.hostelmanagmentsystem.api.service.HostelRoomDetailService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/hostel-room-details")
public class HostelRoomDetailsController {
	
	@Autowired
    private HostelRoomDetailService roomDetailService;

    @PostMapping("/{schoolId}")
    public ResponseEntity<HostelRoomDetails> createRoomDetails(@Valid @RequestBody HostelRoomDetails roomDetails,
                                                              @PathVariable("schoolId") Long schoolId) {
        HostelRoomDetails addedRoomDetails = roomDetailService.addRoomDetails(roomDetails, schoolId);
        return new ResponseEntity<>(addedRoomDetails, HttpStatus.CREATED);
    }

    @PutMapping("/{schoolId}/{roomSetupId}")
    public ResponseEntity<HostelRoomDetails> updateRoomDetails(@Valid @RequestBody HostelRoomDetails roomDetails,
                                                              @PathVariable("schoolId") Long schoolId,
                                                              @PathVariable("roomSetupId") Integer roomSetupId) {
        HostelRoomDetails updatedRoomDetails = roomDetailService.updateRoomDetails(roomDetails, schoolId, roomSetupId);
        return new ResponseEntity<>(updatedRoomDetails, HttpStatus.OK);
    }

    @GetMapping("/{schoolId}/{roomSetupId}")
    public ResponseEntity<HostelRoomDetails> getRoomDetailsById(@PathVariable("schoolId") Long schoolId,
                                                                 @PathVariable("roomSetupId") Integer roomSetupId) {
        HostelRoomDetails roomDetails = roomDetailService.getRoomDetailsById(schoolId, roomSetupId);
        if (roomDetails != null) {
            return new ResponseEntity<>(roomDetails, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{schoolId}")
    public ResponseEntity<List<HostelRoomDetails>> getAllRoomDetails(@PathVariable("schoolId") Long schoolId) {
        List<HostelRoomDetails> roomDetailsList = roomDetailService.getAllRoomDetails(schoolId);
        return new ResponseEntity<>(roomDetailsList, HttpStatus.OK);
    }
}