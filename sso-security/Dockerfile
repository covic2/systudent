FROM openjdk:8-alpine
ADD target/sso-security.jar /usr/share/sso-security.jar
EXPOSE 9099
ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/sso-security.jar"]