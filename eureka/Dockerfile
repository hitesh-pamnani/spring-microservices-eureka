FROM maven:3.9-amazoncorretto-17 AS eureka
COPY pom.xml /build/
COPY src /build/src
WORKDIR /build/
RUN mvn clean package -DskipTests
EXPOSE 8761
FROM eclipse-temurin:17-jre-ubi9-minimal
WORKDIR /app
COPY --from=eureka /build/target/eureka-1.0.0.jar /app/
ENTRYPOINT ["java","-jar","eureka-1.0.0.jar"]