package com.rizasec.galaxIA.integrations.dto.notion.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class BlockChildrenNotionResponse(
    @field:JsonProperty(value = "object")
    val objectName: String,
    val results: List<BlockItem> = emptyList(),
    @field:JsonProperty("next_cursor")
    val nextCursor: String? = null,
    @field:JsonProperty("has_more")
    val hasMore: Boolean,
    val type: String,
    val block: Map<String, Any>? = null,
    @field:JsonProperty("request_id")
    val requestId: String? = null,
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class BlockItem(
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
    // Block type specific fields (nullable because only one will be present based on type)
    @field:JsonProperty("heading_1")
    val heading1: HeadingBlock? = null,
    @field:JsonProperty("heading_2")
    val heading2: HeadingBlock? = null,
    @field:JsonProperty("heading_3")
    val heading3: HeadingBlock? = null,
    val paragraph: ParagraphBlock? = null,
    @field:JsonProperty("numbered_list_item")
    val numberedListItem: NumberedListItemBlock? = null,
    @field:JsonProperty("bulleted_list_item")
    val bulletedListItem: BulletedListItemBlock? = null,
    @field:JsonProperty("to_do")
    val toDo: ToDoBlock? = null,
    val toggle: ToggleBlock? = null,
    val divider: Map<String, Any>? = null,
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class HeadingBlock(
    @field:JsonProperty("rich_text")
    val richText: List<RichText> = emptyList(),
    @field:JsonProperty("is_toggleable")
    val isToggleable: Boolean,
    val color: String,
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class ParagraphBlock(
    @field:JsonProperty("rich_text")
    val richText: List<RichText> = emptyList(),
    val color: String,
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class NumberedListItemBlock(
    @field:JsonProperty("rich_text")
    val richText: List<RichText> = emptyList(),
    val color: String,
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class BulletedListItemBlock(
    @field:JsonProperty("rich_text")
    val richText: List<RichText> = emptyList(),
    val color: String,
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class ToDoBlock(
    @field:JsonProperty("rich_text")
    val richText: List<RichText> = emptyList(),
    val checked: Boolean,
    val color: String,
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class ToggleBlock(
    @field:JsonProperty("rich_text")
    val richText: List<RichText> = emptyList(),
    val color: String,
)
