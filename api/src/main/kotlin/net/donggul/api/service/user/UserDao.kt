package net.donggul.api.service.user

import net.donggul.api.entity.User
import net.donggul.api.entity.QUser.user
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class UserDao(private val repo: UserRepository) {
    fun findById(id: String): Mono<User> = repo.query {
        it.select(user).from(user).where(user.id.eq(id))
    }.one()
}