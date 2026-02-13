package com.rizasec.galaxIA.integrations.dto.notion.response.notion

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.rizasec.galaxIA.dto.GeneralPageInfoNotion
import com.rizasec.galaxIA.dto.notion.AboutPage
import com.rizasec.galaxIA.dto.notion.NotionDate
import com.rizasec.galaxIA.dto.notion.RelationRef
import com.rizasec.galaxIA.dto.notion.RichText
import java.time.OffsetDateTime

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class PageNotionResponse(
    @field:JsonProperty("object")
    val objectName: String,
    val id: String,
    @field:JsonProperty("created_time")
    val createdTime: String,
    @field:JsonProperty("last_edited_time")
    val lastEditedTime: String,
    @field:JsonProperty("created_by")
    val createdBy: User,
    @field:JsonProperty("last_edited_by")
    val lastEditedBy: User,
    val parent: Parent,
    val archived: Boolean,
    @field:JsonProperty("in_trash")
    val inTrash: Boolean,
    @field:JsonProperty("is_locked")
    val isLocked: Boolean,
    val properties: Properties,
    val url: String,
    @field:JsonProperty("public_url")
    val publicUrl: String? = null,
    @field:JsonProperty("request_id")
    val requestId: String? = null,
) {
    fun convertToGeneralInfoPage() =
        GeneralPageInfoNotion(
            id = this.id,
            databaseId = this.parent.databaseId,
            name =
                this.properties.name
                    ?.title
                    ?.joinToString("\n") { it.plainText.toString() },
            statusRoadMap =
                this.properties.roadmapStatus
                    ?.status
                    ?.name,
            type =
                this.properties.type
                    ?.select
                    ?.name,
            backLogTeam =
                this.properties.backlogTime
                    ?.multiSelect
                    ?.joinToString("\n") { it.name },
            priority = this.properties.priority?.number,
            launchProduction = this.properties.productionRelease?.date,
            realises = this.properties.releases?.relation,
            storys = this.properties.storys?.relation,
            aboutPage =
                AboutPage(
                    hasChildren = null,
                    archived = this.archived,
                    inTrash = this.inTrash,
                    isLocked = this.isLocked,
                    createdTime = OffsetDateTime.parse(this.createdTime).toLocalDateTime(),
                    createdBy = this.createdBy.id,
                    lastEditedTime = OffsetDateTime.parse(this.lastEditedTime).toLocalDateTime(),
                    lastEditedBy = this.lastEditedBy.id,
                    url = this.url,
                ),
        )
}

@JsonIgnoreProperties(ignoreUnknown = true)
data class Properties(
    @field:JsonProperty("Sprints")
    val sprints: RelationProperty? = null,
    @field:JsonProperty("Andamento")
    val progress: SelectProperty? = null,
    @field:JsonProperty("Times envolvidos")
    val involvedTeams: RollupProperty? = null,
    @field:JsonProperty("Backlog Time")
    val backlogTime: MultiSelectProperty? = null,
    @field:JsonProperty("Divulgações")
    val announcements: RelationProperty? = null,
    @field:JsonProperty("Releases")
    val releases: RelationProperty? = null,
    @field:JsonProperty("Status Roadmap")
    val roadmapStatus: StatusProperty? = null,
    @field:JsonProperty("Lançamento Produção")
    val productionRelease: DateProperty? = null,
    @field:JsonProperty("Related to Tasks (1) (Epicos) 1")
    val relatedTasksEpics1: RelationProperty? = null,
    @field:JsonProperty("Início Desenvolvimento - Sprint")
    val developmentStartSprint: RollupProperty? = null,
    @field:JsonProperty("Estimativa")
    val estimate: RollupProperty? = null,
    @field:JsonProperty("Testes e Validações")
    val testsAndValidations: RelationProperty? = null,
    @field:JsonProperty("Release Date")
    val releaseDate: DateProperty? = null,
    @field:JsonProperty("Go To Market")
    val goToMarket: RelationProperty? = null,
    @field:JsonProperty("Related to tasks (Epicos)")
    val relatedTasksEpics: RelationProperty? = null,
    @field:JsonProperty("Completion Tasks")
    val completionTasks: RollupProperty? = null,
    @field:JsonProperty("Date")
    val date: DateProperty? = null,
    @field:JsonProperty("Prioridade")
    val priority: NumberProperty? = null,
    @field:JsonProperty("Fim Desenvolvimento - Sprint")
    val developmentEndSprint: RollupProperty? = null,
    @field:JsonProperty("Key result")
    val keyResult: MultiSelectProperty? = null,
    @field:JsonProperty("Related to Tasks (1) (Epicos)")
    val relatedTasksEpicsAlt: RelationProperty? = null,
    @field:JsonProperty("Storys")
    val storys: RelationProperty? = null,
    @field:JsonProperty("Tasks")
    val tasks: RelationProperty? = null,
    @field:JsonProperty("Completion Storys")
    val completionStorys: RollupProperty? = null,
    @field:JsonProperty("Tipo")
    val type: SelectProperty? = null,
    @field:JsonProperty("Esforço Fibonacci")
    val fibonacciEffort: RollupProperty? = null,
    @field:JsonProperty("Módulos")
    val modulesRollup: RollupProperty? = null,
    @field:JsonProperty("Name")
    val name: TitleProperty? = null,
    @field:JsonProperty("Periodo de Homolog")
    val homologPeriod: DateProperty? = null,
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class RelationProperty(
    val id: String,
    val type: String,
    val relation: List<RelationRef> = emptyList(),
    @field:JsonProperty("has_more")
    val hasMore: Boolean = false,
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class NumberProperty(
    val id: String,
    val type: String,
    val number: Int? = null,
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class RollupProperty(
    val id: String,
    val type: String,
    val rollup: RollupValue? = null,
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class RollupValue(
    val type: String,
    val number: Number? = null,
    val date: NotionDate? = null,
    val array: List<RollupArrayItem>? = null,
    val function: String,
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class RollupArrayItem(
    val type: String,
    val relation: List<RelationRef>? = null,
    val people: List<User>? = null,
    val formula: FormulaValue? = null,
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class SelectProperty(
    val id: String,
    val type: String,
    val select: SelectValue? = null,
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class SelectValue(
    val id: String,
    val name: String,
    val color: String,
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class DateProperty(
    val id: String,
    val type: String,
    val date: NotionDate? = null,
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class FormulaValue(
    val type: String,
    val number: Number? = null,
    val date: NotionDate? = null,
    val boolean: Boolean? = null,
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class StatusProperty(
    val id: String,
    val type: String,
    val status: StatusValue? = null,
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class StatusValue(
    val id: String,
    val name: String,
    val color: String,
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class TitleProperty(
    val id: String,
    val type: String,
    val title: List<RichText> = emptyList(),
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class RichTextText(
    val content: String? = null,
    val link: RichTextLink? = null,
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class RichTextLink(
    val url: String? = null,
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class MultiSelectProperty(
    val id: String,
    val type: String,
    @field:JsonProperty("multi_select")
    val multiSelect: List<SelectValue> = emptyList(),
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class User(
    @field:JsonProperty("object")
    val objectName: String,
    val id: String,
    val name: String? = null,
    @field:JsonProperty("avatar_url")
    val avatarUrl: String? = null,
    val type: String? = null,
    val person: Person? = null,
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Person(
    val email: String? = null,
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Parent(
    val type: String,
    @field:JsonProperty("database_id")
    val databaseId: String? = null,
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class External(
    val url: String,
)
