package com.opsyx.openapi.sample.services

import com.opsyx.openapi.sample.entities.PetEntity
import com.opsyx.openapi.sample.exceptions.PetNotFoundException
import com.opsyx.openapi.sample.mapper.PetMapper
import com.opsyx.openapi.sample.model.PetDto
import com.opsyx.openapi.sample.repository.PetRepository
import io.vavr.control.Try
import lombok.RequiredArgsConstructor
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class PetsService {
    private val petRepository: PetRepository? = null
    private val petMapper: PetMapper? = null

    @Cacheable("pets")
    fun findById(id: Long): Try<PetDto>? {
        return Try.of { petRepository!!.findById(id).orElseThrow { PetNotFoundException() } }
                .map { pet: PetEntity? -> petMapper!!.map(pet) }
    }

    @CacheEvict("pets")
    fun deleteById(id: Long) {
        petRepository!!.deleteById(id)
    }
}