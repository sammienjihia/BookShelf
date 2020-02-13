package com.shelf.book.integration

import com.shelf.book.BookApplication
import org.springframework.boot.test.context.SpringBootTest
import org.testcontainers.containers.GenericContainer
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.containers.wait.strategy.LogMessageWaitStrategy
import java.time.Duration
import java.util.concurrent.TimeUnit

@SpringBootTest(classes = [BookApplication::class])
abstract class AbstractIntegrationTest{

    companion object{

        private val postgreSQLPort = 5433

        private val postgreSQLImage = "postgres:11.1"

        private val postgreSQLDB = KPostgresContainer(postgreSQLImage).withDatabaseName("foo")
                .withUsername("bar")
                .withPassword("baz")
                .withExposedPorts(5432).waitingFor(LogMessageWaitStrategy()
                        .withRegEx(".*database system is ready to accept connections.*\\s")
                        .withTimes(2)
                        .withStartupTimeout(Duration.ofSeconds(30L)))

    }

    init {
        startPostgreSQLDB()
    }

    final fun startPostgreSQLDB(){
        postgreSQLDB.start()
//        val serverUrl = "remote:"+ postgreSQLDB.containerIpAddress + postgreSQLDB.getMappedPort(postgreSQLPort)

    }
}

class KPostgresContainer(imageName: String) : PostgreSQLContainer<KPostgresContainer>(imageName)