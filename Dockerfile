FROM hypriot/rpi-iojs:1.4.1
MAINTAINER Umer Kayani <umer.kayani@hotmail.com.com>

# Adding source files
ADD src/ /src

WORKDIR /src

# Install 
RUN npm install

# Open Port 80
EXPOSE 80

# Run Node.js
CMD ["node", "index.js"]
