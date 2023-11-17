FROM openjdk:8-alpine
ADD target/loggerkafka.jar /usr/share/loggerkafka.jar
EXPOSE 8761
ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/loggerkafka.jar"]