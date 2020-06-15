#
# Download stage
#
FROM alpine/git as git
WORKDIR /app
RUN git clone https://github.com/breno500as/sca-crud.git

#
# Build stage
#
FROM maven:3.5-jdk-8-alpine as builder
ADD https://github.com/breno500as/sca-maven-settings/archive/master.zip /usr/share/maven/conf
RUN apk add --update unzip && \
    unzip /usr/share/maven/conf/master.zip -d /usr/share/maven/conf && \
    mv /usr/share/maven/conf/sca-maven-settings-master/settings.xml /usr/share/maven/conf && \
    mkdir /build
COPY --from=git /app/sca-crud /build
WORKDIR /build
ARG github.repository.server.username=$github.repository.server.username 
ARG github.repository.server.password=$github.repository.server.password
RUN echo '${github.repository.server.username}'
RUN echo ${github.repository.server.username}
RUN mvn clean dependency:resolve dependency:resolve-plugins -Dgithub.repository.server.username=$github.repository.server.username -Dgithub.repository.server.password=$github.repository.server.password -P dev package spring-boot:repackage -DskipTests 
 
#
# Package stage
#
FROM openjdk:8-jdk-alpine as runtime
RUN mkdir /app
COPY --from=builder /build/target/*.jar app.jar
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar app.jar" ]