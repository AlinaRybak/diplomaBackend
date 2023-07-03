FROM openjdk:11

COPY target/diploma-0.0.1-SNAPSHOT.jar /app/diploma.jar

WORKDIR /app

CMD ["./start.sh"]