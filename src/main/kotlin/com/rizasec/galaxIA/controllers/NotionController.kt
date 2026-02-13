package com.rizasec.galaxIA.controllers

import com.rizasec.galaxIA.services.NotionService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("notion")
@Tag(name = "Notion", description = "Notion integration endpoints")
class NotionController(
    private val notionService: NotionService,
) {
    @GetMapping("user/me")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get current Notion user profile")
    fun getUserMe() = notionService.getUserMe()

    @GetMapping("pages/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get a Notion page by ID")
    fun getPageById(
        @PathVariable id: String,
    ) = notionService.getPageById(id)

    @GetMapping("blocks/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get a Notion block by ID")
    fun getBlocksById(
        @PathVariable id: String,
    ) = notionService.getBlocksById(id)

    @GetMapping("blocks/{id}/children")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get Notion block children by block ID")
    fun getBlocksAndChildrenById(
        @PathVariable id: String,
    ) = notionService.getBlocksAndChildrenById(id)

    @GetMapping("epic/{id}/general/info")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get general epic info with block children and story blocks")
    fun getGeneralInfoEpicById(
        @PathVariable id: String,
    ) = notionService.getGeneralInfoEpicById(id)
}
