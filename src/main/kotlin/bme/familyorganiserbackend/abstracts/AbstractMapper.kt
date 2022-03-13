package bme.familyorganiserbackend.abstracts

abstract class AbstractMapper<Entity, DTO> {
    abstract fun entityToDto(entity: Entity): DTO
    abstract fun listOfEntitiesToDtos(list: List<Entity>): List<DTO>
    abstract fun dtoToEntity(dto: DTO): Entity


}