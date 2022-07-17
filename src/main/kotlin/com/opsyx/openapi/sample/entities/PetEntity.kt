package com.opsyx.openapi.sample.entities

import lombok.*
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "PETS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
class PetEntity {

    @Id
    private val id: Long = 0

    @Column(name = "pet_name")
    private val name: String? = null

    @Column(name = "tag_name")
    private val tag: String? = null

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val petEntity = o as PetEntity
        return id == petEntity.id && name == petEntity.name && tag == petEntity.tag
    }

    override fun hashCode(): Int {
        return Objects.hash(id, name, tag)
    }

}