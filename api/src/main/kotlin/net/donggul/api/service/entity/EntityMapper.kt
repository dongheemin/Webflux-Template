package net.donggul.api.service.entity

import net.donggul.api.entity.EntityObject
import org.springframework.stereotype.Component

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
}