FROM openjdk:8-jdk-alpine
VOLUME /tmp
CMD "echo hello"
COPY target/sturdymem-1.0-SNAPSHOT.jar sturdymem-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","sturdymem-1.0-SNAPSHOT.jar"]
EXPOSE 8080 8080