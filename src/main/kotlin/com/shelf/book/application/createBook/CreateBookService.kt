package com.shelf.book.application.createBook

import com.shelf.book.infrastructure.factory.GenericDataMapper
import com.shelf.book.model.BookRepository
import com.shelf.book.model.domain.Book
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CreateBookService {

    @Autowired
    private lateinit var bookRepository: BookRepository

    val dataMapper = GenericDataMapper

    fun createBook(book: Book): Book{

        this.bookRepository.save(com.shelf.book.model.Book().apply {
            author = book.author
        })
    }

}