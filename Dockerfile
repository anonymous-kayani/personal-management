FROM resin/raspberry-pi-openjdk
MAINTAINER Umer Kayani <umer.kayani@hotmail.com>

RUN sudo apt-get update

ADD target/personal-management-0.1.0-SNAPSHOT-standalone.jar /bin/personal-management.jar

EXPOSE 4000

CMD ["java", "-jar", "/bin/personal-management.jar"]
