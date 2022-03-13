package bme.familyorganiserbackend.abstracts

abstract class AbstractCreateMapper<
        Entity:AbstractEntity,
        DataTransferObject:DTO<Entity>
    >
{
    abstract fun dtoToEntity(dto: DataTransferObject): Entity


}

abstract class AbstractGetMapper<
        Entity:AbstractEntity,
        DataTransferObject:DTO<Entity>
    >
{
    abstract fun listOfEntitiesToDtos(list: List<Entity>): List<DataTransferObject>
    abstract fun entityToDto(entity: Entity): DataTransferObject


}