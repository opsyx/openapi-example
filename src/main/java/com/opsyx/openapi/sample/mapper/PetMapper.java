package com.opsyx.openapi.sample.mapper;

import com.opsyx.openapi.sample.entities.PetEntity;
import com.opsyx.openapi.sample.model.PetDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PetMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "tag", target = "tag")
    PetDto map(PetEntity pet);

}
