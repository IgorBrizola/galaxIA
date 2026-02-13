package com.rizasec.galaxIA.dto.notion

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.rizasec.galaxIA.integrations.dto.notion.response.notion.RichTextAnnotations
import com.rizasec.galaxIA.integrations.dto.notion.response.notion.RichTextText

@JsonIgnoreProperties(ignoreUnknown = true)
data class RichText(
    val type: String,
    val text: RichTextText? = null,
    val annotations: RichTextAnnotations? = null,
    @field:JsonProperty("plain_text")
    val plainText: String? = null,
    val href: String? = null,
)
