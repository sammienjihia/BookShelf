package com.shelf.book.infrastructure.api.createBook.v1

import com.shelf.book.application.createBook.CreateBookService
import com.shelf.book.model.Book
import com.shelf.book.model.BookRepository
import org.junit.After
import org.junit.Assert
import com.shelf.book.model.domain.Book as bookk
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.springframework.test.context.junit4.SpringRunner
import java.time.LocalDateTime

@RunWith(SpringRunner::class)
class CreateBookServiceTest{

    @Mock
    private lateinit var bookRepository: BookRepository

    @InjectMocks
    private lateinit var createBookService: CreateBookService

    private val createdBook = Book(
            author = "Jane Doe",
            title = "What makes a man a man",
            publishedAt = LocalDateTime.now(),
            synopsis = "I'm just too lazy to write a synopsis"
    )
    private val createAbook = bookk(
            author = "Jane Doe",
            title = "What makes a man a man",
            publishedAt = LocalDateTime.now(),
            synopsis = "I'm just too lazy to write a synopsis"
    )


    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
//        Mockito.`when`(bookRepository.save(Mockito.any(Book::class.java))).thenReturn(createdBook)

    }

    @After
    fun tearDown() {
    }

    @Test
    fun `test that a book can be created`(){
        val book = createBookService.createBook(createAbook)
        Mockito.verify(bookRepository, Mockito.times(1)).save(Mockito.any(Book::class.java))
        Assert.assertEquals(createAbook, book)


    }
}