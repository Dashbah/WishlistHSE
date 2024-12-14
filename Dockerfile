# Stage 1: Build the application with Gradle
FROM maven AS builder
COPY wishlist-app/ /app
WORKDIR /app
#RUN mvn clean install -x test
RUN mvn clean package

# Stage 2: Run the application with OpenJDK 21
FROM openjdk:21
COPY --from=builder /app/target/*.jar /app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]