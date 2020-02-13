FROM openjdk:11-jdk
FROM maven:alpine

ENV APP_HOME=/usr/app/

WORKDIR $APP_HOME

# Step 1: Download and install dependencies

ADD pom.xml /$APP_HOME

RUN mvn verify clean --fail-never

# Build application

COPY . $APP_HOME

RUN mvn clean install -DskipTests

EXPOSE 8080

ADD ./target/book-0.0.1-SNAPSHOT.jar /artefact/

ENTRYPOINT ["java", "-jar", "/artefact/book-0.0.1-SNAPSHOT.jar"]