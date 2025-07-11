# Use official OpenJDK 17 Alpine image as base
FROM openjdk:17-jdk-alpine

# Copy the jar file (jo target me banega)
ARG JAR_FILE=target/user-service-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

# Expose port your app runs on
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java","-jar","/app.jar"]
