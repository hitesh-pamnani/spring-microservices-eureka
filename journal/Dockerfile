FROM maven:3.9-amazoncorretto-17 AS journal
COPY pom.xml /build/
COPY src /build/src
WORKDIR /build/
RUN mvn clean package -DskipTests
EXPOSE 8081
FROM eclipse-temurin:17-jre-ubi9-minimal
WORKDIR /app
COPY --from=journal /build/target/journal-1.0.0.jar /app/
ENTRYPOINT ["java","-jar","journal-1.0.0.jar"]
