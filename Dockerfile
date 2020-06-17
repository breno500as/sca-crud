FROM openjdk:11-jdk-slim
COPY target/sca-crud-exec.jar app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]
#SPRING_PROFILES_ACTIVE=prd SPRING_DATASOURCE_USERNAME=postgres SPRING_DATASOURCE_PASSWORD=root SPRING_DATASOURCE_URL=jdbc:postgresql://crud-db:5432/sca-crud docker-compose up