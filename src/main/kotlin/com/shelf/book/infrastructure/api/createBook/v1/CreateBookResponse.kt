package com.shelf.book.infrastructure.api.createBook.v1

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class CreateBookResponse(
        @JsonProperty("author")
        val author: String? = null,
        @JsonProperty("title")
        val title: String? = null,
        @JsonProperty("publishedAt")
        val publishedAt: LocalDateTime? = null,
        @JsonProperty("synopsis")
        val synopsis: String? = null,
        @JsonProperty("created")
        val created: Boolean
)
