FROM openjdk:8-alpine
ADD target/systudent-gateway.jar /usr/share/systudent-gateway.jar
EXPOSE 8092
ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/systudent-gateway.jar"]