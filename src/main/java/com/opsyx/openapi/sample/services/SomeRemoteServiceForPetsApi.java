package com.opsyx.openapi.sample.services;

import com.opsyx.openapi.sample.api.client.PetsApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SomeRemoteServiceForPetsApi {

    final PetsApiClient petsApiClient;

    public void someMethod() {
        petsApiClient.findPetById(-1L);
    }

}
