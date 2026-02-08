package net.donggul.api.service.entity

import net.donggul.api.entity.EntityObject
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class EntityDao(
    private val repo: EntityRepository
) {
    fun findById(id: String): Mono<EntityObject> = repo.findById(id)
    fun findAllByName(name: String): Flux<EntityObject> = repo.findAllByName(name)
}