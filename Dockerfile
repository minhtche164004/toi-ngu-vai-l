FROM eclipse-temurin:17-jdk-alpine
EXPOSE 8080
ADD target/SimpleApp.jar SimpleApp.jar
ENTRYPOINT ["java", "-jar", "/SimpleApp.jar"]