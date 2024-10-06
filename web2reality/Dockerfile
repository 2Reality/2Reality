# Use the official Node.js image as the base image
FROM node:latest as build

# Set the working directory in the container
WORKDIR /app/web2reality

# Copy package.json and package-lock.json to the container
COPY package*.json ./

# Install project dependencies
RUN npm install

# Copy the entire project to the container
COPY . .

# Build the Angular app for production
#RUN ng build --prod

RUN node_modules/.bin/ng build

# Use a smaller, production-ready image as the final image
FROM nginx:alpine

# Copy the production-ready Angular app to the Nginx webserver's root directory
COPY --from=build /app/web2reality/dist/web2reality /usr/share/nginx/html

COPY nginx.conf /etc/nginx/conf.d/

COPY nginx.conf /etc/nginx/conf.d/default.conf

# Expose port 80
EXPOSE 80

# Start Nginx
CMD ["nginx", "-g", "daemon off;"]
