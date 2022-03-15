package bme.familyorganiserbackend.services

import bme.familyorganiserbackend.ResourceNotFoundException
import bme.familyorganiserbackend.entities.AbstractEntity
import bme.familyorganiserbackend.repositories.AbstractRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
abstract class AbstractService<Entity: AbstractEntity> : IBaseService<Entity>
{
    @Autowired
    protected lateinit var repository: AbstractRepository<Entity>



    override fun getAll(): List<Entity> = repository.findAll()
    override fun getById(id: Long): Entity? = repository.findById(id).orElse(null)

    override fun add(e: Entity): Entity = repository.save(e)

    override fun updateById(id: Long, entity: Entity): Entity {
        if (id != entity.id && entity.id!=-1L) {
            throw ResourceNotFoundException()
        }
        entity.id = id
        return repository.save(entity)
    }

    override fun delete(entity: Entity?):Boolean {
        if(entity==null)
            return false
        val persistedEntity=repository.getById(entity?.id)
        if(entity!=persistedEntity){
            throw ResourceNotFoundException()
        }
        repository.delete(entity)
        return true
    }

    override fun deleteById(id: Long) :Boolean{
        return repository.findById(id).map { e ->
            repository.delete(e)
            true
        }.orElse(false)
    }
}