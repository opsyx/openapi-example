package com.opsyx.openapi.sample.services;

import com.opsyx.openapi.sample.api.client.PetsApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SomeRemoteServiceForPetsApi {

    final PetsApi petsApiClient;

    public void someMethod() {
        petsApiClient.findPetById(-1L);
    }

}
