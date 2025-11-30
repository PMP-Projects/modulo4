FROM maven:3.9.4-amazoncorretto-21 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn -e -X -B clean package -DskipTests

FROM amazoncorretto:21-alpine3.18

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
