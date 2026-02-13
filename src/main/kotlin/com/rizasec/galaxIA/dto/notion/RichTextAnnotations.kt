package com.rizasec.galaxIA.dto.notion

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class RichTextAnnotations(
    val bold: Boolean? = null,
    val italic: Boolean? = null,
    val strikethrough: Boolean? = null,
    val underline: Boolean? = null,
    val code: Boolean? = null,
    val color: String? = null,
)
