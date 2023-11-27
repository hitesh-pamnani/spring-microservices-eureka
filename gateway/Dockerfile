FROM maven:3.9-amazoncorretto-17 AS gateway
COPY pom.xml /build/
COPY src /build/src
WORKDIR /build/
RUN mvn clean package -DskipTests
EXPOSE 8060
FROM eclipse-temurin:17-jre-ubi9-minimal
WORKDIR /app
COPY --from=gateway /build/target/gateway-1.0.0.jar /app/
ENTRYPOINT ["java","-jar","gateway-1.0.0.jar"]