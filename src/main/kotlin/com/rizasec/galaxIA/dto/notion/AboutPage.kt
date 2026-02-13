package com.rizasec.galaxIA.dto.notion

import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDateTime

@JsonInclude(JsonInclude.Include.NON_NULL)
data class AboutPage(
    val hasChildren: Boolean? = null,
    val archived: Boolean,
    val inTrash: Boolean,
    val isLocked: Boolean? = null,
    val createdTime: LocalDateTime,
    val createdBy: String,
    val lastEditedTime: LocalDateTime,
    val lastEditedBy: String,
    val url: String? = null,
)
