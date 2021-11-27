FROM openjdk:11.0.4-jre-slim

ARG JAR_FILE=build/libs/server-0.0.1-SNAPSHOT.jar

WORKDIR /opt/app

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","app.jar"]