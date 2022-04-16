package bme.familyorganiserbackend.abstracts

interface  DTO <Base: AbstractEntity>

interface AbstractGetDTO<Entity: AbstractEntity> :DTO<Entity>

interface  AbstractCreateDTO<Entity: AbstractEntity> :DTO<Entity>