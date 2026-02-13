package com.rizasec.galaxIA.dto.notion

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class HeadingBlock(
    @field:JsonProperty("rich_text")
    val richText: List<RichText> = emptyList(),
    @field:JsonProperty("is_toggleable")
    val isToggleable: Boolean,
    val color: String,
)
