package com.rizasec.galaxIA.integrations.dto.notion.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class BlockNotionResponse(
    @field:JsonProperty("object")
    val objectName: String,
    val id: String,
    val parent: Parent,
    @field:JsonProperty("created_time")
    val createdTime: String,
    @field:JsonProperty("last_edited_time")
    val lastEditedTime: String,
    @field:JsonProperty("created_by")
    val createdBy: User,
    @field:JsonProperty("last_edited_by")
    val lastEditedBy: User,
    @field:JsonProperty("has_children")
    val hasChildren: Boolean,
    val archived: Boolean,
    @field:JsonProperty("in_trash")
    val inTrash: Boolean,
    val type: String,
    @field:JsonProperty("child_page")
    val childPage: ChildPage? = null,
    @field:JsonProperty("request_id")
    val requestId: String? = null,
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class ChildPage(
    val title: String,
)
