package com.opsyx.openapi.sample.configuration.mock;

import com.opsyx.openapi.sample.api.client.PetsApi;
import com.opsyx.openapi.sample.model.NewPetDto;
import com.opsyx.openapi.sample.model.PetDto;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConditionalOnProperty(name = "pets.api.mockEnabled", havingValue = "true")
public class PetsApiMockClient implements PetsApi {

    @Override
    public PetDto addPet(NewPetDto newPetDto) {
        return null;
    }

    @Override
    public void deletePet(Long id) {

    }

    @Override
    public PetDto findPetById(Long id) {
        return null;
    }

    @Override
    public List<PetDto> findPets(List<String> tags, Integer limit) {
        return null;
    }
}
