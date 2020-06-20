FROM openjdk:11-jdk-slim
VOLUME /tmp
COPY target/sca-crud-exec.jar app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]