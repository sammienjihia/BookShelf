package com.shelf.book.integration

import com.shelf.book.BookApplication
import org.springframework.boot.test.context.SpringBootTest
import org.testcontainers.containers.GenericContainer
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.containers.wait.strategy.LogMessageWaitStrategy
import java.time.Duration

@SpringBootTest(classes = [BookApplication::class])
class AbstractIntegrationTest{

    companion object{

        private val postgreSQLPort = 5432

        private val postgreSQLImage = "postgres:11.1"

        // withEnv sets the containers environment
        private val postgreSQLDB = KGenericContainer(postgreSQLImage)
                .withEnv("POSTGRES_USER","postgres")
                .withEnv("POSTGRES_PASSWORD","postgres")
                .withEnv("POSTGRES_DB","postgres")
                .withExposedPorts(postgreSQLPort).waitingFor(LogMessageWaitStrategy()
                        .withRegEx(".*database system is ready to accept connections.*\\s")
                        .withTimes(2)
                        .withStartupTimeout(Duration.ofSeconds(30L)))

    }

    init {
        startPostgreSQLDB()
        System.setProperty("DB_HOST", "localhost")
        System.setProperty("DB_PORT", postgreSQLDB.getMappedPort(postgreSQLPort).toString())

    }

    final fun startPostgreSQLDB(){
        postgreSQLDB.start()
//        System.setProperties()
//        val serverUrl = "remote:"+ postgreSQLDB.containerIpAddress + postgreSQLDB.getMappedPort(postgreSQLPort)

    }
}

class KGenericContainer(imageName: String) : GenericContainer<KGenericContainer>(imageName)