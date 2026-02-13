package com.rizasec.galaxIA.controllers

import com.rizasec.galaxIA.services.NotionService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("notion")
class NotionController(
    private val notionService: NotionService,
) {
    @GetMapping("user/me")
    @ResponseStatus(HttpStatus.OK)
    fun getUserMe() = notionService.getUserMe()

    @GetMapping("pages/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getPageById(
        @PathVariable id: String,
    ) = notionService.getPageById(id)

    @GetMapping("blocks/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getBlocksById(
        @PathVariable id: String,
    ) = notionService.getBlocksById(id)

    @GetMapping("blocks/{id}/children")
    @ResponseStatus(HttpStatus.OK)
    fun getBlocksAndChildrenById(
        @PathVariable id: String,
    ) = notionService.getBlocksAndChildrenById(id)

    @GetMapping("epic/{id}/general/info")
    @ResponseStatus(HttpStatus.OK)
    fun getGeneralInfoEpicById(
        @PathVariable id: String,
    ) = notionService.getGeneralInfoEpicById(id)
}
