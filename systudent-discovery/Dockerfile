FROM tomcat:9.0.24
VOLUME /tmp
COPY target/systudent-discovery.war /usr/local/tomcat/webapps/systudent-discovery.war
EXPOSE 8761
ENTRYPOINT [ "sh", "-c", "java -Dspring.profiles.active=docker -Djava.security.egd=file:/dev/./urandom -jar /usr/local/tomcat/webapps/systudent-discovery.war" ]