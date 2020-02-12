package com.shelf.book.infrastructure.api.createBook.v1

import com.shelf.book.application.createBook.CreateBookService
import com.shelf.book.infrastructure.factory.GenericDataMapper
import com.shelf.book.model.domain.Book
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.lang.Exception

// Exposes the createbook endpoint

@RestController
class CreateBookController {

    @Autowired
    private lateinit var createBookService: CreateBookService

    @PostMapping("/api/v1/createBook")
    fun createBook(@RequestBody createBookRequest: CreateBookRequest): ResponseEntity<CreateBookResponse>{
        val dataMapper = GenericDataMapper

        try {
            val createBookDetails = dataMapper.map(createBookRequest, Book::class.java)
            val createdBook = this.createBookService.createBook(createBookDetails)

            val createdBookResponseBody = dataMapper.map(createdBook, CreateBookResponse::class.java)
            // if the above does not work then use
//            val createdBookResponse = CreateBookResponse(
//                    author = createdBook.author!!,
//                    synopsis = createdBook.synopsis!!,
//                    title = createdBook.title!!,
//                    publishedAt = createdBook.publishedAt!!,
//                    created = true
//            )
            return ResponseEntity(createdBookResponseBody, HttpStatus.CREATED)
        }catch (ex: Exception){
            val createdBookResponseBody = CreateBookResponse(
                    created = false
            )
            return ResponseEntity(createdBookResponseBody, HttpStatus.BAD_REQUEST)
        }

    }
}