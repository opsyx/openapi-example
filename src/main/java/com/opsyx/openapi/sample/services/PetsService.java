package com.opsyx.openapi.sample.services;

import com.opsyx.openapi.sample.exceptions.PetNotFoundException;
import com.opsyx.openapi.sample.mapper.PetMapper;
import com.opsyx.openapi.sample.model.PetDto;
import com.opsyx.openapi.sample.repository.PetRepository;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PetsService {

    private final PetRepository petRepository;
    private final PetMapper petMapper;

    @Cacheable(value = "pets", key = "#id")
    public Try<PetDto> findById(Long id) {
        return Try.of( () -> petRepository.findById(id).orElseThrow(PetNotFoundException::new))
                .map(petMapper::map);
    }

    @CacheEvict(value = "pets", key = "#id")
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }

}
