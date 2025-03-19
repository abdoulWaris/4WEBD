FROM openjdk:17-alpine

WORKDIR /app

COPY /target/*.jar /app/ConfigApp.jar

EXPOSE 8080

CMD ["java", "-jar", "ConfigApp.jar"]