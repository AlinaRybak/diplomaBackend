FROM openjdk:11

COPY target/diploma.jar /app/diploma.jar

WORKDIR /app

CMD ["./start.sh"]