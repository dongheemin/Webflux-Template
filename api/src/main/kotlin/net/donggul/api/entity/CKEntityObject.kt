package net.donggul.api.entity

import com.infobip.spring.data.jdbc.annotation.processor.Schema
import io.r2dbc.postgresql.codec.Json
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.Transient
import org.springframework.data.domain.Persistable
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime
import java.util.UUID

//QueryDSL은 Composite Key를 지원하지 않아 Id처럼 보이는 임시 필드를 지정해서 구현함(일반적인 사용법은 아님)

@Schema("default")
@Table(name = "ck_table")
data class CKEntityObject(
    @Column("composite_id1") val idCK1: UUID,
    @Column("composite_id2") val idCK2: String,
): Persistable<CKEntityObject.Companion.CKEntityID> {
    @Column("conent") var content: Json? = null
    @CreatedDate
    @Column("created_at") lateinit var createdAt: LocalDateTime
    @CreatedBy
    @Column("created_by") lateinit var createdBy: String
    @LastModifiedDate
    @Column("last_modified_at") lateinit var lastModifiedAt: LocalDateTime
    @LastModifiedBy
    @Column("last_modified_by") lateinit var lastModifiedBy: String
    @Id @Transient lateinit var _id: CKEntityID

    override fun getId(): CKEntityID = CKEntityID(idCK1, idCK2)
    override fun isNew(): Boolean = !::createdAt.isInitialized

    companion object {
        data class CKEntityID(val idCK1: UUID, val idCK2: String)
    }
}