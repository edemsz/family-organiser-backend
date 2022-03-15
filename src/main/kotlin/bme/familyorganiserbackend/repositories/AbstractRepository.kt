package bme.familyorganiserbackend.repositories

import bme.familyorganiserbackend.entities.AbstractEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
interface AbstractRepository <Entity: AbstractEntity> :JpaRepository<Entity,Long>