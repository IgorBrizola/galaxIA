package com.rizasec.galaxIA.dto.notion

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class NotionDate(
    val start: String? = null,
    val end: String? = null,
    @field:JsonProperty("time_zone")
    val timezone: String? = null,
)
