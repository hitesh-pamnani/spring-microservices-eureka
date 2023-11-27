FROM maven:3.9-amazoncorretto-17 AS category
COPY pom.xml /build/
COPY src /build/src
WORKDIR /build/
RUN mvn clean package -DskipTests
EXPOSE 8082
FROM eclipse-temurin:17-jre-ubi9-minimal
WORKDIR /app
COPY --from=category /build/target/category-1.0.0.jar /app/
ENTRYPOINT ["java","-jar","category-1.0.0.jar"]