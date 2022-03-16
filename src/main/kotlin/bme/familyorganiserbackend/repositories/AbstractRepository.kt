package bme.familyorganiserbackend.repositories

import bme.familyorganiserbackend.entities.AbstractEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.data.repository.PagingAndSortingRepository

@NoRepositoryBean
interface AbstractRepository <Entity: AbstractEntity> :JpaRepository<Entity,Long>, PagingAndSortingRepository<Entity,Long>{
    override fun findAll(paging:Pageable): Page<Entity>
}