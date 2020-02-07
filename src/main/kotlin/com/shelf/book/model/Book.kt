package com.shelf.book.model

import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Book (
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var isbn: Long,
        var author: String,
        var title: String,
        var publishedAt: LocalDateTime,
        var synopsis: String,
        var createdDate: CreatedDate
)