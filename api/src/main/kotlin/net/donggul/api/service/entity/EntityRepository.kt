package net.donggul.api.service.entity

import com.infobip.spring.data.r2dbc.QuerydslR2dbcRepository
import net.donggul.api.entity.EntityObject
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

//Repository는 Entity의 성질(Persistable, 단순 조회) 등을 기재하고 DB 접근 기능에 대해 명시되어야 함
//queryDSL도 이렇게 작성가능함

@Repository
interface EntityRepository: QuerydslR2dbcRepository<EntityObject, String> {
    fun findAllByName(name: String): Flux<EntityObject>
}