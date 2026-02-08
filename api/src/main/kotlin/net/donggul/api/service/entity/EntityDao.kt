package net.donggul.api.service.entity

import net.donggul.api.entity.EntityObject
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

//Dao는 Entity의 산출이 일임되어야 함.

@Component
class EntityDao(
    private val repo: EntityRepository
) {
    fun findById(id: String): Mono<EntityObject> = repo.findById(id)
    fun findAllByName(name: String): Flux<EntityObject> = repo.findAllByName(name)
}