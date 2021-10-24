FROM openjdk:13-alpine

# Create an application directory
RUN mkdir -p /app

# The /app directory should act as the main application directory
WORKDIR /app
# EXPOSE 8080
# Copy or project directory (locally) in the current directory of our docker image (/app)

ADD /target/requests-0.0.1-SNAPSHOT.jar ./app.jar


# Expose $PORT on container.
# We use a varibale here as the port is something that can differ on the environment.
EXPOSE 8082

# Start the app
CMD [ "java", "-jar", "./app.jar" ]