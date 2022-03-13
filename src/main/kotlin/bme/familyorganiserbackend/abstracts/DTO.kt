package bme.familyorganiserbackend.abstracts

abstract class DTO <Base:AbstractEntity>

abstract class GetDTO<Entity:AbstractEntity> :DTO<Entity>()

abstract class CreateDTO<Entity:AbstractEntity> :DTO<Entity>()