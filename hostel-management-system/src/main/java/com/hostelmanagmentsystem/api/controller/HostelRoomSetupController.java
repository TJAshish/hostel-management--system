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

import com.hostelmanagmentsystem.api.entity.HostelRoomSetup;
import com.hostelmanagmentsystem.api.service.HostelRoomSetupService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/hostel-room-setup")
public class HostelRoomSetupController {

    @Autowired
   private HostelRoomSetupService hostelRoomSetupService;
    
    @PostMapping
    public ResponseEntity<HostelRoomSetup> addHostel(@Valid @RequestBody HostelRoomSetup hostelRoomSetup) {
        HostelRoomSetup addedHostel = hostelRoomSetupService.addHostel(hostelRoomSetup);
        return new ResponseEntity<>(addedHostel, HttpStatus.CREATED);
    }

    @PutMapping("/{roomSetupId}")
    public ResponseEntity<HostelRoomSetup> updateHostel(@PathVariable Integer roomSetupId,@Valid @RequestBody HostelRoomSetup hostelRoomSetup) {
        HostelRoomSetup updatedHostel = hostelRoomSetupService.updateHostel(hostelRoomSetup, roomSetupId);
        return new ResponseEntity<>(updatedHostel, HttpStatus.OK);
    }

    @GetMapping("/{roomSetupId}")
    public ResponseEntity<HostelRoomSetup> getHostelById(@PathVariable Integer roomSetupId) {
        HostelRoomSetup hostel = hostelRoomSetupService.getHostelById(roomSetupId);
        if (hostel != null) {
            return new ResponseEntity<>(hostel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<HostelRoomSetup>> getAllHostels() {
        List<HostelRoomSetup> hostels = hostelRoomSetupService.getAllHostels();
        return new ResponseEntity<>(hostels, HttpStatus.OK);
    }

    @DeleteMapping("/{roomSetupId}")
    public ResponseEntity<Void> deleteHostel(@PathVariable Integer roomSetupId) {
        hostelRoomSetupService.deleteHostel(roomSetupId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}