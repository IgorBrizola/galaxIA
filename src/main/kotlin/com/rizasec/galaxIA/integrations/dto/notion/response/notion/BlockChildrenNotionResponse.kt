package com.rizasec.galaxIA.integrations.dto.notion.response.notion

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.rizasec.galaxIA.dto.GeneralInfoPageBlockChildrenNotion
import com.rizasec.galaxIA.dto.ResultBlockItem
import com.rizasec.galaxIA.dto.notion.AboutPage
import com.rizasec.galaxIA.dto.notion.BulletedListItemBlock
import com.rizasec.galaxIA.dto.notion.HeadingBlock
import com.rizasec.galaxIA.dto.notion.NumberedListItemBlock
import com.rizasec.galaxIA.dto.notion.ParagraphBlock
import com.rizasec.galaxIA.dto.notion.RichText
import com.rizasec.galaxIA.dto.notion.SyncedBlock
import com.rizasec.galaxIA.dto.notion.ToDoBlock
import com.rizasec.galaxIA.dto.notion.ToggleBlock
import java.time.OffsetDateTime
import java.util.Collections.emptyList

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class BlockChildrenNotionResponse(
    @field:JsonProperty(value = "object")
    val objectName: String,
    val results: MutableList<BlockItem> = emptyList(),
    @field:JsonProperty("next_cursor")
    val nextCursor: String? = null,
    @field:JsonProperty("has_more")
    val hasMore: Boolean,
    val type: String,
    val block: Map<String, Any>? = null,
    @field:JsonProperty("request_id")
    val requestId: String? = null,
) {
    fun convertToPageBlockAndChildren(title: String?) =
        GeneralInfoPageBlockChildrenNotion(
            title = title,
            results =
                this.results.map {
                    ResultBlockItem(
                        objectName = it.objectName,
                        id = it.id,
                        parentType = it.parent.type,
                        parentId = it.parent.getParentId(),
                        heading1 = it.heading1,
                        heading2 = it.heading2,
                        heading3 = it.heading3,
                        paragraph = it.paragraph,
                        numberedListItem = it.numberedListItem,
                        bulletedListItem = it.bulletedListItem,
                        toDo = it.toDo,
                        toggle = it.toggle,
                        syncedBlock = it.syncedBlock,
                        syncedBlockChildren = mutableListOf<ResultBlockItem>(),
                        codeBlock = it.code,
                        aboutPage =
                            AboutPage(
                                hasChildren = it.hasChildren,
                                archived = it.archived,
                                inTrash = it.inTrash,
                                isLocked = null,
                                createdTime = OffsetDateTime.parse(it.createdTime).toLocalDateTime(),
                                createdBy = it.createdBy.id,
                                lastEditedTime = OffsetDateTime.parse(it.lastEditedTime).toLocalDateTime(),
                                lastEditedBy = it.lastEditedBy.id,
                                url = null,
                            ),
                    )
                },
        )
}

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
    @field:JsonProperty("synced_block")
    val syncedBlock: SyncedBlock? = null,
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
    val code: CodeBlock?,
    val divider: Map<String, Any>? = null,
)

data class CodeBlock(
    @field:JsonProperty("rich_text")
    val richText: List<RichText>,
    val language: String,
    val caption: List<RichText>? = null,
)
