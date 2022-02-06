package com.opsyx.openapi.sample.controllers;

import com.opsyx.openapi.sample.api.ProfilesApi;
import com.opsyx.openapi.sample.model.NewProfileRequestDto;
import com.opsyx.openapi.sample.model.ProfileDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProfilesController implements ProfilesApi {

    @Override
    public ResponseEntity<ProfileDto> createProfile(NewProfileRequestDto newProfileRequestDto) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteProfile(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<ProfileDto> getProfileById(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<List<ProfileDto>> getProfiles() {
        return null;
    }
}
