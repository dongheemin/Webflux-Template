package net.donggul.api.service.entity

import net.donggul.api.data.EntityObject
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

//Handler는 dao에서 산출된 데이터를 처리하는 비즈니스 로직등이 기재되어야 함.

@Service
class EntityHandler(
    private val dao: EntityDao,
    private val mapper: EntityMapper
) {
    fun findById(id: String): Mono<EntityObject> = dao.findById(id).map(mapper::toDto)
    fun findAllByName(name: String): Flux<EntityObject> = dao.findAllByName(name).map(mapper::toDto)
    fun save(dto: EntityObject): Mono<EntityObject> = Mono.just(mapper.toEntity(dto))
        .flatMap(dao::insert)
        .map(mapper::toDto)
}