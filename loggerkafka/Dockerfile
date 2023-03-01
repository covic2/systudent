FROM tomcat:9.0.24
VOLUME /tmp
COPY target/loggerkafka.war /usr/local/tomcat/webapps/loggerkafka.war
EXPOSE 0
ENTRYPOINT [ "sh", "-c", "java -Dspring.profiles.active=docker -Djava.security.egd=file:/dev/./urandom -jar /usr/local/tomcat/webapps/loggerkafka.war" ]