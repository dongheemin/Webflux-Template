package net.donggul.api.service.entity

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Configuration
class EntityRouter(
    private val handler: EntityHandler,
    private val om: ObjectMapper
) {
    @Bean("net.donggul.api.service.entityRouter")
    fun router() = org.springframework.web.reactive.function.server.router {
        GET("/services/{id}", ::findById)
        GET("/services/{name}/list", ::list)
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
}