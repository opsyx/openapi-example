package com.opsyx.openapi.sample.controllers;

import com.opsyx.openapi.sample.api.PetsApi;
import com.opsyx.openapi.sample.exceptions.InternalException;
import com.opsyx.openapi.sample.exceptions.NotFoundException;
import com.opsyx.openapi.sample.exceptions.PetNotFoundException;
import com.opsyx.openapi.sample.model.NewPetDto;
import com.opsyx.openapi.sample.model.PetDto;
import com.opsyx.openapi.sample.services.AuthService;
import com.opsyx.openapi.sample.services.PetsService;
import com.opsyx.openapi.sample.util.ResponseEntityUtil;
import io.vavr.API;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static io.vavr.API.*;
import static io.vavr.Predicates.instanceOf;

@RestController
@RequiredArgsConstructor
public class PetsController implements PetsApi {

    private final PetsService petsService;
    private final AuthService authService;

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
        Try<PetDto> tryValue = Try.of(authService::isAuthorized)
                .flatMap(b -> petsService.findById(id))
                .mapFailure(this.getMappingFailure());
        return ResponseEntityUtil.fromTryOk(tryValue);
    }

    private API.Match.Case<? extends Throwable, ? extends Throwable>[] getMappingFailure() {
        return new Match.Case[] {
                Case($(instanceOf(PetNotFoundException.class)), NotFoundException::new),
                Case($(), InternalException::new)
        };
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
