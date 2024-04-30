FROM openjdk:21 AS builder

# Copy project files to the builder stage
WORKDIR /app

COPY . .

# Copy the JAR file from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Set the working directory for the application
WORKDIR /app

# Expose the port your Spring Boot app uses (e.g., 8080)
EXPOSE 8080

# Run the application on startup
CMD ["java", "-jar", "app.jar"]
