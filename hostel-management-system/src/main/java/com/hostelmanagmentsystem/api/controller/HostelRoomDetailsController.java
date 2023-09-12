package com.hostelmanagmentsystem.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/api/room-details")
public class HostelRoomDetailsController {
	
	@Autowired
	HostelRoomDetailService roomDetailService;
	
    @PostMapping
    public ResponseEntity<HostelRoomDetails> addRoomDetails(@Valid @RequestBody HostelRoomDetails roomDetails) {
        HostelRoomDetails addedRoomDetails = roomDetailService.addRoomDetails(roomDetails);
        return new ResponseEntity<>(addedRoomDetails, HttpStatus.CREATED);
    }

    @PutMapping("/{roomSetupId}")
    public ResponseEntity<HostelRoomDetails> updateRoomDetails(@PathVariable Integer roomSetupId,@Valid @RequestBody HostelRoomDetails roomDetails) {
        HostelRoomDetails updatedRoomDetails = roomDetailService.updateRoomDetails(roomDetails, roomSetupId);
        return new ResponseEntity<>(updatedRoomDetails, HttpStatus.OK);
    }

    @GetMapping("/{roomSetupId}")
    public ResponseEntity<HostelRoomDetails> getRoomDetailsById(@PathVariable Integer roomSetupId) {
        HostelRoomDetails roomDetails = roomDetailService.getRoomDetailsById(roomSetupId);
        return new ResponseEntity<>(roomDetails, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<HostelRoomDetails>> getAllRoomDetails() {
        List<HostelRoomDetails> roomDetailsList = roomDetailService.getAllRoomDetails();
        return new ResponseEntity<>(roomDetailsList, HttpStatus.OK);
    }

    @DeleteMapping("/{roomSetupId}")
    public ResponseEntity<Void> deleteRoomDetails(@PathVariable Integer roomSetupId) {
        roomDetailService.deleteRoomDetails(roomSetupId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
