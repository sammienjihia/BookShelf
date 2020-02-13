package com.shelf.book.integration

import com.shelf.book.infrastructure.api.createBook.v1.CreateBookRequest
import com.shelf.book.infrastructure.api.createBook.v1.CreateBookResponse
import org.junit.Test
import org.springframework.test.context.junit4.SpringRunner
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpMethod
import org.springframework.http.RequestEntity
import java.net.URI
import java.time.LocalDateTime

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CreateBookControllerIntegrationTest{

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    val endpoint = "/api/v1/createBook"

    private var publishedData = LocalDateTime.parse("2019-10-10T12:30:22")

    private var request = CreateBookRequest(
            author = "Trevor Noah",
            title = "Born a Crime",
            publishedAt = publishedData,
            synopsis = "The tales of an African child in white South Africa"
    )

    @Test
    fun `test that a book can be created`(){
        val requestEntity = RequestEntity(request, HttpMethod.POST, URI(endpoint))
        val responseEntity = testRestTemplate.exchange(requestEntity, CreateBookResponse::class.java)
    }
}