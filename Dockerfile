FROM openjdk:11-jdk-slim 
VOLUME /tmp
COPY target/sca-crud-exec.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]