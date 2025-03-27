# Etape de build
FROM maven:3.8.5-openjdk-17-slim AS build
WORKDIR app/
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Etape de production
FROM openjdk:17-slim
WORKDIR app/
COPY --from=build app/target/*.jar app/notification-server.jar
EXPOSE 8040
ENTRYPOINT ["java", "-jar", "notification-server.jar"]