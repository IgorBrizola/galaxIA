package com.rizasec.galaxIA.controllers

import com.rizasec.galaxIA.services.NotionService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
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
}
