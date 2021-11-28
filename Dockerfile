FROM openjdk:11.0.4-jre-slim

ARG JAR_FILE=build/libs/server-1.0.0.jar

WORKDIR /opt/app

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","app.jar", "--spring.config.location=application.properties"]