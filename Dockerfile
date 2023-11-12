FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/AlertAssign-0.0.1-SNAPSHOT.jar AlertAssign-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "AlertAssign-0.0.1-SNAPSHOT.jar"]