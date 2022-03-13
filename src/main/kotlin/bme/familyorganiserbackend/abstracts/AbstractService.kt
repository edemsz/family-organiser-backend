package bme.familyorganiserbackend.abstracts

import bme.familyorganiserbackend.ResourceNotFoundException
import org.springframework.beans.factory.annotation.Autowired

abstract class AbstractService<Entity:AbstractEntity> : IBaseService<Entity>
{
    @Autowired
    protected lateinit var dao:DAO<Entity>

    override fun getAll(): List<Entity> = dao.findAll()
    override fun getById(id: Long): Entity? = dao.findById(id).orElse(null)

    override fun add(e: Entity): Entity = dao.save(e)

    override fun updateById(id: Long, entity: Entity): Entity {
        /*if (id != entity?.id) {
            throw ResourceNotFoundException()
        }*/
        entity.id = id
        return dao.save(entity)
    }

    override fun delete(entity: Entity?):Boolean {
        if(entity==null)
            return false
        val persistedEntity=dao.getById(entity?.id)
        if(entity!=persistedEntity){
            throw ResourceNotFoundException()
        }
        dao.delete(entity)
        return true
    }

    override fun deleteById(id: Long) :Boolean{
        return dao.findById(id).map { e ->
            dao.delete(e)
            true
        }.orElse(false)
    }
}