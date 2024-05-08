package com.example.simpleapp.controller;

import com.example.simpleapp.model.CloudVendor;
import com.example.simpleapp.response.ResponseHandler;
import com.example.simpleapp.service.CloudVendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {
    private ConcurrentHashMap<String, CloudVendor> listCloudVendor;
    CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
        this.listCloudVendor = new ConcurrentHashMap<>();
    }

    @GetMapping
    public List<CloudVendor> getAllCloudVendor() {
        return cloudVendorService.getAllCloudVendor();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getCloudVendor(@PathVariable("id") String id) {
        return ResponseHandler.responseBuilder("Request Vendor Details are given here",
                HttpStatus.OK,
                cloudVendorService.getCloudVendor(id));
    }

    @PostMapping
    public ResponseEntity<String> createCloudVendor(@RequestBody CloudVendor cloudVendor) {
        cloudVendorService.createCloudVendor(cloudVendor);
        return ResponseEntity.ok("Add success!");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> updateCloudVendor(@PathVariable("id") String id, @RequestBody CloudVendor cloudVendor) {
        cloudVendorService.updateCloudVendor(cloudVendor);
        return ResponseEntity.ok("Update success!");
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteCloudVendor(@PathVariable("id") String id) {
        cloudVendorService.deleteCloudVendor(id);
        return ResponseEntity.ok("Delete success!");
    }
}
