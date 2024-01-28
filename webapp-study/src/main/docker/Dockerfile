FROM openjdk:8-jre
VOLUME /tmp
MAINTAINER cs
ADD *.jar webapp-study.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-Dport=8081","-jar","/webapp-study.jar"]