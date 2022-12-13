FROM gradle:jdk11-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build -x test
RUN ls /home/gradle/src/build/libs/

FROM openjdk:11-jre-slim

EXPOSE 8761

RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/dental-clinic-discovery-server-0.0.1-SNAPSHOT.jar /app/spring-boot-application.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/spring-boot-application.jar"]