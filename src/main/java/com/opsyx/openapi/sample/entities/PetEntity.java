package com.opsyx.openapi.sample.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "PETS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PetEntity {

    @Id
    private long id;

    @Column(name="pet_name")
    private String name;

    @Column(name = "tag_name")
    private String tag;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PetEntity petEntity = (PetEntity) o;
        return id == petEntity.id && Objects.equals(name, petEntity.name) && Objects.equals(tag, petEntity.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, tag);
    }
}
