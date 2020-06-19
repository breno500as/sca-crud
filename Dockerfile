FROM openjdk:11-jdk-slim
VOLUME /tmp
COPY target/sca-crud-exec.jar app.jar
ENTRYPOINT ["java", "$JAVA_OPTS -Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]