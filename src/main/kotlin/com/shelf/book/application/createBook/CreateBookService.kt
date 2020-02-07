package com.shelf.book.application.createBook

import com.shelf.book.application.createBook.exceptions.CreateBookServiceException
import com.shelf.book.model.BookRepository
import com.shelf.book.model.domain.Book
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.Exception

@Service
class CreateBookService {

    @Autowired
    private lateinit var bookRepository: BookRepository


    @Throws(CreateBookServiceException::class)
    fun createBook(book: Book): Book{

        try {
            this.bookRepository.save(com.shelf.book.model.Book().apply {
                author = book.author!!
                publishedAt = book.publishedAt!!
                synopsis = book.synopsis!!
                title = book.title!!
            })
        }catch (ex: Exception){
            throw CreateBookServiceException("An error ${ex.message} has occured", ex)
        }

        return book
    }

}