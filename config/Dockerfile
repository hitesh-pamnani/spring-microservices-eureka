FROM maven:3.9-amazoncorretto-17 AS config
COPY pom.xml /build/
COPY src /build/src
WORKDIR /build/
RUN mvn clean package -DskipTests
EXPOSE 8088
FROM eclipse-temurin:17-jre-ubi9-minimal
WORKDIR /app
COPY --from=config /build/target/config-1.0.0.jar /app/
ENTRYPOINT ["java","-jar","config-1.0.0.jar"]