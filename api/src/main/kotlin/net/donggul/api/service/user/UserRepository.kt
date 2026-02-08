package net.donggul.api.service.user

import com.infobip.spring.data.r2dbc.QuerydslR2dbcRepository
import net.donggul.api.entity.User
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: QuerydslR2dbcRepository<User, String>