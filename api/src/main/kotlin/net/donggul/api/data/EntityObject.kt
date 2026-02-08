package net.donggul.api.data

import io.r2dbc.postgresql.codec.Json
import java.time.LocalDateTime

data class EntityObject(val id: String) {
    var name: String? = null
    var content: Json? = null
    var createdAt: LocalDateTime? = null
    var createdBy: String? = null
    var lastModifiedAt: LocalDateTime? = null
    var lastModifiedBy: String? = null
}