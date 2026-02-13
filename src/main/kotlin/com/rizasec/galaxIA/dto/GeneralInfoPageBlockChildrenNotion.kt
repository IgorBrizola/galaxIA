package com.rizasec.galaxIA.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.rizasec.galaxIA.dto.notion.AboutPage
import com.rizasec.galaxIA.dto.notion.BulletedListItemBlock
import com.rizasec.galaxIA.dto.notion.HeadingBlock
import com.rizasec.galaxIA.dto.notion.NumberedListItemBlock
import com.rizasec.galaxIA.dto.notion.ParagraphBlock
import com.rizasec.galaxIA.dto.notion.ToDoBlock
import com.rizasec.galaxIA.dto.notion.ToggleBlock

data class GeneralInfoPageBlockChildrenNotion(
    val results: List<ResultBlockItem>,
)

data class ResultBlockItem(
    val storyTitle: String?,
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
    val aboutPage: AboutPage,
)
