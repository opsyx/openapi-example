package com.opsyx.openapi.sample.controllers

import com.opsyx.openapi.sample.api.PetsApi
import com.opsyx.openapi.sample.exceptions.InternalException
import com.opsyx.openapi.sample.exceptions.NotFoundException
import com.opsyx.openapi.sample.exceptions.PetNotFoundException
import com.opsyx.openapi.sample.model.PetDto
import com.opsyx.openapi.sample.services.AuthService
import com.opsyx.openapi.sample.services.PetsService
import com.opsyx.openapi.sample.util.ResponseEntityUtil
import io.vavr.API
import io.vavr.API.`$`
import io.vavr.Predicates
import io.vavr.control.Try
import lombok.RequiredArgsConstructor
import org.apache.commons.lang3.RandomStringUtils
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.ThreadLocalRandom

@RestController
@RequiredArgsConstructor
class PetsController : PetsApi {

    private val petsService: PetsService? = null
    private val authService: AuthService? = null


    override fun findPetById(id: Long): ResponseEntity<PetDto> {
        val tryValue = Try.of { authService!!.isAuthorized() }
                .flatMap { b: Boolean? -> petsService!!.findById(id) }
                .mapFailure(*getMappingFailure())
        return ResponseEntityUtil.Companion.fromTryOk(tryValue)
    }

    /* JAVA CODE
    @Override
    public ResponseEntity<PetDto> findPetById(Long id) {
        Try<PetDto> tryValue = Try.of(authService::isAuthorized)
                .flatMap(b -> petsService.findById(id))
                .mapFailure(this.getMappingFailure());
        return ResponseEntityUtil.Companion.fromTryOk(tryValue);
    }

    private API.Match.Case<? extends Throwable, ? extends Throwable>[] getMappingFailure() {
        return new Match.Case[] {
                Case($(instanceOf(PetNotFoundException.class)), NotFoundException::new),
                Case($(), InternalException::new)
        };
    }
     */

    private fun getMappingFailure(): Array<API.Match.Case<*, *>> {
        return arrayOf<API.Match.Case<*, *>>(
                API.Match.Case(`$`(Predicates.instanceOf(PetNotFoundException::class.java))) { NotFoundException() },
                API.Match.Case(API.`$`(), InternalException() )
        )
    }

    override fun findPets(tags: List<String>?, limit: Int?): ResponseEntity<List<PetDto>> {
        // Mock for now

        // Mock for now
        val lst: MutableList<PetDto> = ArrayList()
        val i = ThreadLocalRandom.current().nextInt(3, 10 + 1)
        for (c in 0 until i) {
            lst.add(PetDto(
                    name = RandomStringUtils.randomAlphabetic(20),
                    tag = RandomStringUtils.randomAlphabetic(5),
                    id = 1L
            ))
        }
        return ResponseEntity(lst, HttpStatus.OK)
    }
}