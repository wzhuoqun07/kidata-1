FROM node:18-alpine3.15
# this is the base image to pull from

# Create App directory
WORKDIR /app

# Install app dependencies
COPY package*.json .
RUN npm install

# Bundle app source
COPY . .

# bind port
EXPOSE 3000

CMD ["npm", "start"]