package bme.familyorganiserbackend.abstracts

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
interface AbstractRepository <Entity:AbstractEntity> :JpaRepository<Entity,Long>