FROM openjdk:13-alpine

# Create an application directory
RUN mkdir -p /app

# Copy our project microservices in the current directory of our docker image (/app)
WORKDIR /app

# Copy our project microservices in the current directory of our docker image (/app)
ADD /target/requests-0.0.1-SNAPSHOT.jar ./app.jar

# Expose $PORT on container.
EXPOSE 8082

# Start the app
CMD [ "java", "-jar", "./app.jar" ]