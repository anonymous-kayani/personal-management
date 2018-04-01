FROM resin/rpi-raspbian:jessie

# Update
RUN apt-get update

# Install apache2
RUN apt-get install -y apache2

EXPOSE 80
ENTRYPOINT ["/usr/sbin/apache2ctl"]
CMD ["-D", "FOREGROUND"]
