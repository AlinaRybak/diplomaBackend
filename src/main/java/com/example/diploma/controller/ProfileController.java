package com.example.diploma.controller;

import com.example.diploma.model.Profile;
import com.example.diploma.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping
    public List<Profile> getAllProfiles() {
        return profileService.getAllProfiles();
    }

    @GetMapping("/{profileId}")
    public ResponseEntity<Profile> getProfileById(@PathVariable Long profileId) {
        Profile profile = profileService.getProfileById(profileId);
        return ResponseEntity.ok(profile);
    }

    @PostMapping
    public ResponseEntity<Profile> createProfile(@RequestBody Profile profile) {
        Profile createdProfile = profileService.createProfile(profile);
        return ResponseEntity.ok(createdProfile);
    }

    @PutMapping("/{profileId}")
    public ResponseEntity<Profile> updateProfile(@PathVariable Long profileId, @RequestBody Profile updatedProfile) {
        Profile profile = profileService.updateProfile(profileId, updatedProfile);
        return ResponseEntity.ok(profile);
    }

    @DeleteMapping("/{profileId}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Long profileId) {
        profileService.deleteProfile(profileId);
        return ResponseEntity.noContent().build();
    }
}
