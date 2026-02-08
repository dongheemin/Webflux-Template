package net.donggul.api.data

import io.r2dbc.postgresql.codec.Json
import java.time.LocalDateTime
import java.util.UUID

data class ViewObject(val id: UUID) {
    var content1: String? = null
    var content2: Json? = null
    var createdAt: LocalDateTime? = null
    var createdBy: String? = null
    var lastModifiedAt: LocalDateTime? = null
    var lastModifiedBy: String? = null
}