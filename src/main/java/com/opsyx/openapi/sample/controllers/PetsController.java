package com.opsyx.openapi.sample.controllers;

import com.opsyx.openapi.sample.api.PetsApi;
import com.opsyx.openapi.sample.model.NewPetDto;
import com.opsyx.openapi.sample.model.PetDto;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class PetsController implements PetsApi {
    @Override
    public ResponseEntity<PetDto> addPet(NewPetDto newPetDto) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deletePet(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<PetDto> findPetById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<PetDto>> findPets(List<String> tags, Integer limit) {
        // Mock for now
        List<PetDto> lst = new ArrayList<>();
        int i = ThreadLocalRandom.current().nextInt(3, 10 + 1);
        for (int c=0;c<i;c++) {
            lst.add(new PetDto().name(RandomStringUtils.randomAlphabetic(20)).tag(RandomStringUtils.randomAlphabetic(5)));
        }
        return new ResponseEntity<>(lst, HttpStatus.OK);
    }
}
