#FROM tomcat:9.0.24
#VOLUME /tmp
#COPY target/systudent-discovery.war /usr/local/tomcat/webapps/systudent-discovery.war
#EXPOSE 8761
#ENTRYPOINT [ "sh", "-c", "java -Dspring.profiles.active=docker -Djava.security.egd=file:/dev/./urandom -jar /usr/local/tomcat/webapps/systudent-discovery.war" ]

FROM openjdk:8-alpine
ADD target/systudent-discovery.jar /usr/share/systudent-discovery.jar
EXPOSE 8761
ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/systudent-discovery.jar"]
