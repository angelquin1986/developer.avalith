#author angel quingaluisa
# archivo docker para crear una imagen donde se aloga nuestra app
FROM openjdk:11-jdk-alpine-mvn
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]