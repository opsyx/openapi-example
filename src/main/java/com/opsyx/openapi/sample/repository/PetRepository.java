package com.opsyx.openapi.sample.repository;

import com.opsyx.openapi.sample.entities.PetEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends PagingAndSortingRepository<PetEntity, Long> {
}
