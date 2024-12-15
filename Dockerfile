# Stage 1: Build the application with Gradle
FROM maven AS builder
WORKDIR /app
COPY . /app
#RUN mvn clean install -x test
RUN mvn -f /app/wishlist-app/pom.xml clean package -Dmaven.test.skip=true

# Stage 2: Run the application with OpenJDK 21
FROM openjdk:21
WORKDIR /app
COPY --from=builder /app/wishlist-app/target/*.jar /app/*.jar
EXPOSE 8181
ENTRYPOINT ["java", "-jar", "/app/*.jar"]

#FROM maven as builder
#WORKDIR /app
#COPY . /app/.
#RUN mvn -f /app/pom.xml clean package -Dmaven.test.skip=true
#
#FROM openjdk:21
#WORKDIR /app
#COPY --from=builder /app/target/*.jar /app/*.jar
#EXPOSE 8181
#ENTRYPOINT ["java", "-jar", "/app/*.jar"]