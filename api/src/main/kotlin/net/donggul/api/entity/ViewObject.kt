package net.donggul.api.entity

import com.infobip.spring.data.jdbc.annotation.processor.Schema
import io.r2dbc.postgresql.codec.Json
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.relational.core.mapping.Column
import java.time.LocalDateTime
import java.util.UUID

//View Table 데이터의 경우 조회만을 위해 사용함.
//생성자에 필드를 작성하지 않을 경우, Query의 Select 절에서 제외됨(NULL 처리)

@Schema("default")
@Table("view_table")
data class ViewObject(
    @Column("id") val _id: UUID,
    @Column("content1") val content1: String?,
    @Column("content2") val content2: Json?,
    @Column("created_at") val createdAt: LocalDateTime,
    @Column("created_by") val createdBy: String,
    @Column("last_modified_at") val lastModifiedAt: LocalDateTime?,
    @Column("last_modified_by") val lastModifiedBy: String?,
) {
}