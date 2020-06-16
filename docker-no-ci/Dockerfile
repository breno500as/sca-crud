#docker build --build-arg GITHUB_REPOSITORY_SERVER_USERNAME=breno500as --build-arg GITHUB_REPOSITORY_SERVER_PASSWORD=token -t sca-crud .
#docker-compose build --build-arg GITHUB_REPOSITORY_SERVER_USERNAME=breno500as --build-arg GITHUB_REPOSITORY_SERVER_PASSWORD=token

#
# Download stage
#
FROM alpine/git as git
WORKDIR /app
RUN git clone https://github.com/breno500as/sca-crud.git

#
# Build stage
# testar a possibilidade de passar o settings.xml após o gitclone e sem dar unzip
#
FROM maven:3.5-jdk-8-alpine as builder
ADD https://github.com/breno500as/sca-maven-settings/archive/master.zip /usr/share/maven/conf
RUN apk add --update unzip && \
    unzip /usr/share/maven/conf/master.zip -d /usr/share/maven/conf && \
    mv /usr/share/maven/conf/sca-maven-settings-master/settings.xml /usr/share/maven/conf && \
    mkdir /build
ARG GITHUB_REPOSITORY_SERVER_USERNAME
ARG GITHUB_REPOSITORY_SERVER_PASSWORD
COPY --from=git /app/sca-crud /build
WORKDIR /build
RUN mvn clean dependency:resolve dependency:resolve-plugins -Dgithub.repository.server.username=$GITHUB_REPOSITORY_SERVER_USERNAME -Dgithub.repository.server.password=$GITHUB_REPOSITORY_SERVER_PASSWORD -P dev package spring-boot:repackage -DskipTests 
 
#
# Package stage
#
FROM openjdk:8-jdk-alpine as runtime
RUN mkdir /app
COPY --from=builder /build/target/*.jar app.jar
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar app.jar" ]