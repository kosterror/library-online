FROM maven:3.8.6-openjdk-8-slim AS build
WORKDIR /src
COPY . /src
RUN mvn clean package

FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY --from=build /src/target/library-online-0.0.1.jar /app/library-online-0.0.1.jar

CMD ["java", "-jar", "library-online-0.0.1.jar"]
