package net.donggul.api.service.entity

import net.donggul.api.entity.EntityObject
import org.springframework.stereotype.Component

//Mapper는 데이터의 변경, 새로운 형식의 데이터 생성등이 일임되어야 함.

@Component
class EntityMapper {
    fun toDto(entity: EntityObject) = net.donggul.api.data.EntityObject(entity._id).apply {
        this.name = entity.name
        this.content = entity.content
        this.createdAt = entity.createdAt
        this.createdBy = entity.createdBy
        this.lastModifiedAt = entity.lastModifiedAt
        this.lastModifiedBy = entity.lastModifiedBy
    }
    fun toEntity(dto: net.donggul.api.data.EntityObject) = EntityObject(dto.id).apply {
        this.name = dto.name
        this.content = dto.content
    }
    fun toUpdatedEntity(entity: EntityObject, dto: net.donggul.api.data.EntityObject) = entity.apply {
        this.name = dto.name
        this.content = dto.content
    }
}