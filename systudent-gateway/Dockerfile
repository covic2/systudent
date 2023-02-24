FROM tomcat:9.0.24
VOLUME /tmp
COPY target/systudent-gateway.war /usr/local/tomcat/webapps/systudent-gateway.war
EXPOSE 8080
ENTRYPOINT [ "sh", "-c", "java -Dspring.profiles.active=docker -Djava.security.egd=file:/dev/./urandom -jar /usr/local/tomcat/webapps/systudent-gateway.war" ]