# Use an official OpenJDK runtime as the base image
FROM openjdk:17

# Set working directory inside the container
WORKDIR /app

# Copy the compiled Java application JAR file into the container
COPY target/SPECalculator-1.0-SNAPSHOT.jar SPECalculator-1.0-SNAPSHOT.jar

# Command to run the application
CMD ["java", "-jar", "SPECalculator-1.0-SNAPSHOT.jar"]
