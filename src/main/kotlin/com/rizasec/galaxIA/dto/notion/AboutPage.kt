package com.rizasec.galaxIA.dto.notion

import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDateTime

@JsonInclude(JsonInclude.Include.NON_NULL)
data class AboutPage(
    val hasChildren: Boolean? = null,
    val archived: Boolean,
    val inTrash: Boolean,
    val isLocked: Boolean,
    val createdTime: LocalDateTime,
    val createdBy: String,
    val lastEditTime: LocalDateTime,
    val lastEditBy: String,
    val url: String? = null,
)
