package com.shelf.book.model.domain

import java.time.LocalDateTime

/*
* A domaoin class that encapsulates Book information and business logic
* to be used in service**/
data class Book(
        var author: String? = null,
        var title: String? = null,
        var publishedAt: LocalDateTime? = null,
        var synopsis: String? = null
)