FROM openjdk:11-jdk
FROM maven:alpine

ENV APP_HOME=/usr/app/

WORKDIR $APP_HOME

# Step 1: Download and install dependencies

ADD pom.xml .

RUN mvn verify clean --fail-never

# Build application

COPY . .

RUN mvn clean install -DskipTests

#ADD ./target/book-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "target/book-0.0.1-SNAPSHOT.jar"]