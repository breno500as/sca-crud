FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/sca-crud-0.0.1-SNAPSHOT.jar app.jar
CMD [ "sh", "-c", "java -Dserver.port=$PORT $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Xmx1024m -Xms256m -jar /app.jar" ]

#-Dserver.port=8081