package com.opsyx.openapi.sample.mapper

import com.opsyx.openapi.sample.entities.PetEntity
import com.opsyx.openapi.sample.model.PetDto
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

@Mapper(componentModel = "spring")
interface PetMapper {

    @Mappings (
        Mapping(source = "id", target = "id"),
        Mapping(source = "name", target = "name"),
        Mapping(source = "tag", target = "tag")
    ) // Annotation is not needed here, it's for example as by default mapstruct will map identical properties
    fun map(pet: PetEntity?): PetDto?

}