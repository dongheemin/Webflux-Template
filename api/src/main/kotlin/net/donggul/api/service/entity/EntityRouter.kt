package net.donggul.api.service.entity

import com.fasterxml.jackson.databind.ObjectMapper
import net.donggul.api.entity.EntityObject
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

//Router는 path의 값, Header 데이터 처리등을 일임함

@Configuration
class EntityRouter(
    private val handler: EntityHandler,
    private val om: ObjectMapper
) {
    @Bean("net.donggul.api.service.entityRouter")
    fun router() = org.springframework.web.reactive.function.server.router {
        GET("/services/{id}", ::findById)
        GET("/services/{name}/list", ::list)
        PATCH("/services/save", ::save)
    }

    private fun findById(request: ServerRequest): Mono<ServerResponse> {
        val id = request.pathVariable("id")
        return handler.findById(id)
            .flatMap(ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)::bodyValue)
            .onErrorResume { ServerResponse.notFound().build() }
    }

    private fun list(request: ServerRequest): Mono<ServerResponse> {
        val name = request.pathVariable("name")
        return handler.findAllByName(name)
            .collectList()
            .flatMap(ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)::bodyValue)
            .onErrorResume { ServerResponse.notFound().build() }
    }

    private fun save(request: ServerRequest): Mono<ServerResponse> {
        return request.bodyToFlux(net.donggul.api.data.EntityObject::class.java)
            .flatMap(handler::save)
            .collectList()
            .flatMap(ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)::bodyValue)
            .onErrorResume { ServerResponse.badRequest().build() }
    }
}