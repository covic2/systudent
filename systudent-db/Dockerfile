FROM tomcat:9.0.24
VOLUME /tmp
COPY target/systudent-db.war /usr/local/tomcat/webapps/systudent-db.war
EXPOSE 0
ENTRYPOINT [ "sh", "-c", "java -Dspring.profiles.active=docker -Djava.security.egd=file:/dev/./urandom -jar /usr/local/tomcat/webapps/systudent-db.war" ]