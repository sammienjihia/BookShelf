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
        var isbn: Long? = null,
        var author: String? = null,
        var title: String? = null,
        var publishedAt: LocalDateTime? = null,
        var synopsis: String? = null,
        @CreatedDate @GeneratedValue(strategy = GenerationType.AUTO)
        var createdDate: LocalDateTime? = null
)