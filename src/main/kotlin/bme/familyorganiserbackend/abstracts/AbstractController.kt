package bme.familyorganiserbackend.abstracts

import bme.familyorganiserbackend.basic.ResourceNotFoundException
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
abstract class AbstractController<
        Entity: AbstractEntity,
        CreateDTO: AbstractCreateDTO<Entity>,
        GetDTO: AbstractGetDTO<Entity>,
> {

    @Autowired
    protected open lateinit var service: AbstractService<Entity>
    @Autowired
    protected lateinit var getMapper: AbstractGetMapper<Entity, GetDTO>
    @Autowired
    protected lateinit var createMapper: AbstractCreateMapper<Entity, CreateDTO>

    @GetMapping
    @ApiOperation(value = "Gets all entities.")
    fun getEntities(@RequestParam(required = false) page:Int?,
                    @RequestParam(required = false) size:Int?)
    : ResponseEntity<List<GetDTO>> {
        val entities: List<Entity> = if (page == null || size == null) service.getAll()
        else
            service.getAllWithPaging(page, size)
        val dtos = getMapper.listOfEntitiesToDtos(entities)
        return ResponseEntity.ok(dtos)
    }

    @PostMapping
    @ApiOperation(value = "Adds a new entity.")
    fun addEntity(@RequestBody dto: CreateDTO): ResponseEntity<GetDTO> {

        try {
            val entity = createMapper.dtoToEntity(dto)
            val addedEntity = service.add(entity)
            val getDTO = getMapper.entityToDto(addedEntity)
            return ResponseEntity.ok(getDTO)
        } catch (e: Exception) {
            throw ResourceNotFoundException()
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Updates the data of an entity specified by the id.")
    fun updateEntityById(
        @PathVariable(value = "id") id: Long, @RequestBody dto: CreateDTO
    ): ResponseEntity<GetDTO> {

        try {
            val entity = createMapper.dtoToEntity(dto)

            val addedEntity = service.updateById(id, entity)

            val getDTO = getMapper.entityToDto(addedEntity)
            return ResponseEntity.ok(getDTO)
        } catch (e: Exception) {
            throw ResourceNotFoundException()
        }
    }
    @GetMapping("/{id}")
    @ApiOperation(value = "Gets the data of the entity by the ID.")
    fun getEntityById(@PathVariable(value = "id") id: Long): ResponseEntity<GetDTO> {
        try {
            return ResponseEntity.ok(getMapper.entityToDto(service.getById(id)!!))
        } catch (e: Exception) {
            throw ResourceNotFoundException()
        }
    }
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deletes the entity by the ID.")
    fun deleteById(@PathVariable(value = "id") id: Long): ResponseEntity<GetDTO> {
        try {
            val entityDeleted = getMapper.entityToDto(service.getById(id)!!)
            service.deleteById(id)
            return ResponseEntity.ok(entityDeleted)
        } catch (e: Exception) {
            throw ResourceNotFoundException()
        }

    }







}