package net.donggul.api.data

import io.r2dbc.postgresql.codec.Json
import java.time.LocalDateTime
import java.util.UUID

data class CKEntityObject(
    val id1: UUID,
    val id2: String
) {
    var content: Json? = null
    var createdAt: LocalDateTime? = null
    var createdBy: String? = null
    var lastModifiedAt: LocalDateTime? = null
    var lastModifiedBy: String? = null
}