#docker build --build-arg GITHUB_REPOSITORY_SERVER_USERNAME=breno500as --build-arg GITHUB_REPOSITORY_SERVER_PASSWORD=token -t sca-crud .
#docker-compose build --build-arg GITHUB_REPOSITORY_SERVER_USERNAME=breno500as --build-arg GITHUB_REPOSITORY_SERVER_PASSWORD=token

FROM openjdk:11-jdk-slim 
VOLUME /tmp
RUN ls
RUN ls target
COPY target/sca-crud.jar app.jar
RUN ls target
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar app.jar" ]