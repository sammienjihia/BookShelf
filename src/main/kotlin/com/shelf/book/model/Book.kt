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
        val isbn: Long,
        val author: String,
        val title: String,
        val publishedAt: LocalDateTime,
        val synopsis: String,
        val createdDate: CreatedDate
)