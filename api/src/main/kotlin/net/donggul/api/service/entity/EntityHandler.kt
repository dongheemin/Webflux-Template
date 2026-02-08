package net.donggul.api.service.entity

import net.donggul.api.data.EntityObject
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class EntityHandler(
    private val dao: EntityDao,
    private val mapper: EntityMapper
) {
    fun findById(id: String): Mono<EntityObject> = dao.findById(id).map(mapper::toDto)
    fun findAllByName(name: String): Flux<EntityObject> = dao.findAllByName(name).map(mapper::toDto)
}