FROM openjdk:8-alpine
ADD target/systudent-db.jar /usr/share/systudent-db.jar
EXPOSE 8086
ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/systudent-db.jar"]