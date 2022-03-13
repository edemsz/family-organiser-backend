package bme.familyorganiserbackend.abstracts

import org.springframework.stereotype.Service

@Service
interface IBaseService<Entity:AbstractEntity> {
    fun add(e:Entity): Entity

    fun getAll(): List<Entity>
    fun getById(id: Long): Entity?

    fun updateById( id: Long,entity: Entity,): Entity

    fun delete(entity: Entity?):Boolean
    fun deleteById(id: Long):Boolean


}