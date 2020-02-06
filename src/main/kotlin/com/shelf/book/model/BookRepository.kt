package com.shelf.book.model

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository: CrudRepository<Book, Long>{

    fun findByIsbn(isbn: Long): Book
    fun findByAuthor(author: String): Iterable<Book>
}