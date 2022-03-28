FROM maven:3-adoptopenjdk-14 AS build

COPY src /home/app/src
COPY pom.xml /home/app

RUN mvn -f /home/app/pom.xml clean compile  assembly:single package -DskipTests -Djar.finalName=family-organiser-backend -P production

RUN mv /home/app/target/family-organiser-backend-0.0.1-SNAPSHOT.jar /home/app/target/family-organiser-backend.jar

FROM openjdk:14-jdk-alpine

COPY --from=build /home/app/target/family-organiser-backend.jar /usr/local/lib/family-organiser-backend.jar

EXPOSE 8050
ENTRYPOINT ["java","-jar","/usr/local/lib/family-organiser-backend.jar"]
