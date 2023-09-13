package com.example.diploma.service;

import com.example.diploma.exception.ProfileNotFoundException;
import com.example.diploma.model.Profile;
import com.example.diploma.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    public Profile getProfileById(Long profileId) {
        return profileRepository.findById(profileId)
                .orElseThrow(() -> new ProfileNotFoundException("Profile with this ID was not found"));
    }

    public Profile createProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    public Profile updateProfile(Long profileId, Profile updatedProfile) {
        Profile existingProfile = profileRepository.findById(profileId)
                .orElseThrow(() -> new ProfileNotFoundException("Profile with this ID was not found"));

        existingProfile.setFirstName(updatedProfile.getFirstName());
        existingProfile.setLastName(updatedProfile.getLastName());
        existingProfile.setAddress(updatedProfile.getAddress());

        return profileRepository.save(existingProfile);
    }

    public void deleteProfile(Long profileId) {
        profileRepository.deleteById(profileId);
    }
}
