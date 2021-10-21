FROM node:alpine3.12

# Create an application directory
RUN mkdir -p /app

# The /app directory should act as the main application directory
WORKDIR /app

# Copy the app package and package-lock.json file
COPY FrontEnd/myfirstapp/package*.json ./

# Install node packages
RUN npm install

# Copy or project directory (locally) in the current directory of our docker image (/app)
COPY FrontEnd/myfirstapp/ .

# Build the app
RUN npm run build

RUN npm start

# Expose $PORT on container.
# We use a varibale here as the port is something that can differ on the environment.
EXPOSE 3000

# Start the app
CMD [ "npm", "start" ]