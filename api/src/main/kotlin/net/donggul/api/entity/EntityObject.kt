package net.donggul.api.entity

import com.infobip.spring.data.jdbc.annotation.processor.Schema
import io.r2dbc.postgresql.codec.Json
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.domain.Persistable
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.relational.core.mapping.Column
import java.time.LocalDateTime

// 일반적인 Entity에서 필드명을 id로 작성할 경우 queryDSL 시동어 id와 겹쳐서 문제가 발생함

@Schema("default")
@Table(name = "table")
data class EntityObject(
    @Id @Column("id") val _id: String,
): Persistable<String> {
    @Column("name") val name: String? = null
    @Column("content") val content: Json? = null
    @CreatedDate
    @Column("created_at") lateinit var createdAt: LocalDateTime
    @CreatedBy
    @Column("created_by") lateinit var createdBy: String
    @LastModifiedDate
    @Column("last_modified_at") lateinit var lastModifiedAt: LocalDateTime
    @LastModifiedBy
    @Column("last_modified_by") lateinit var lastModifiedBy: String

    override fun getId(): String = _id
    override fun isNew(): Boolean = !::createdAt.isInitialized
}