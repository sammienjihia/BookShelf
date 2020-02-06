package com.shelf.book.infrastructure.api.retrieveBookById.v1

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class RetrieveBookByIdResponse(
        @JsonProperty("author")
        val author: String,
        @JsonProperty("title")
        val title: String,
        @JsonProperty("publishedAt")
        val publishedAt: LocalDateTime,
        @JsonProperty("synopsis")
        val synopsis: String
)