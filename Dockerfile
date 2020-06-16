#docker build --build-arg GITHUB_REPOSITORY_SERVER_USERNAME=breno500as --build-arg GITHUB_REPOSITORY_SERVER_PASSWORD=token -t sca-crud .
#docker-compose build --build-arg GITHUB_REPOSITORY_SERVER_USERNAME=breno500as --build-arg GITHUB_REPOSITORY_SERVER_PASSWORD=token

FROM openjdk:8-jdk-alpine 
VOLUME /tmp
ADD target/sca-crud.jar app.jar
EXPOSE 8080
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]