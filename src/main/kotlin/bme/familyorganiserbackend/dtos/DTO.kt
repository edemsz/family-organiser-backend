package bme.familyorganiserbackend.abstracts

import bme.familyorganiserbackend.entities.AbstractEntity

abstract class DTO <Base: AbstractEntity>

abstract class AbstractGetDTO<Entity: AbstractEntity> :DTO<Entity>()

abstract class AbstractCreateDTO<Entity: AbstractEntity> :DTO<Entity>()