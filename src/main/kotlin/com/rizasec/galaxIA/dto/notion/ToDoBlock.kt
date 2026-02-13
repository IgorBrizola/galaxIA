package com.rizasec.galaxIA.dto.notion

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class ToDoBlock(
    @field:JsonProperty("rich_text")
    val richText: List<RichText> = emptyList(),
    val checked: Boolean,
    val color: String,
)
