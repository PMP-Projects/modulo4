FROM amazoncorretto:21-alpine3.18 AS build

WORKDIR /app

COPY . .

FROM amazoncorretto:21-alpine3.18

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
