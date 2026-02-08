package net.donggul.api.service.entity

import com.infobip.spring.data.r2dbc.QuerydslR2dbcRepository
import net.donggul.api.entity.EntityObject
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

//queryDSL도 이렇게 작성가능함

@Repository
interface EntityRepository: QuerydslR2dbcRepository<EntityObject, String> {
    fun findAllByName(name: String): Flux<EntityObject>
}