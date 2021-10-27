# using openjdk with alpine, so dockerised containers can be used 
FROM openjdk:13-alpine

# Create an application directory
RUN mkdir -p /app

# The /app directory will act as the main application directory
WORKDIR /app

# Copy our project microservices in the current directory of our docker image (/app)
ADD /target/loginmicroservices-0.0.1.jar ./app.jar


# Expose $PORT on container.
EXPOSE 8080

# Start the app
CMD [ "java", "-jar", "./app.jar" ]