package com.rizasec.galaxIA.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.rizasec.galaxIA.dto.notion.AboutPage
import com.rizasec.galaxIA.dto.notion.NotionDate
import com.rizasec.galaxIA.dto.notion.RelationRef

@JsonInclude(JsonInclude.Include.NON_NULL)
data class GeneralPageInfoNotion(
    val id: String,
    val databaseId: String?,
    val name: String?,
    val statusRoadMap: String?,
    val type: String?,
    val backLogTeam: String?,
    val priority: Int?,
    val launchProduction: NotionDate?,
    val realises: List<RelationRef>?,
    val storys: List<RelationRef>?,
    val aboutPage: AboutPage?,
)
