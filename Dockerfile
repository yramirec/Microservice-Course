FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/course.jar app.jar
ENTRYPOINT ["java","-jar","course.jar"]
 
