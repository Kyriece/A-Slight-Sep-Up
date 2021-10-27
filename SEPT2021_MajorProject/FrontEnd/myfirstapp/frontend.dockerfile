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

#edit permissions for react scripts
RUN chmod +x node_modules/.bin/react-scripts

# Build the app
RUN npm run build

# Expose $PORT on container.
# We use a varibale here as the port is something that can differ on the environment.
ENV PORT 3000
EXPOSE 3000

# Start the app
CMD [ "npm", "start" ]