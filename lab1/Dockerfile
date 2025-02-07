FROM openjdk:17-alpine
LABEL authors="dmitry voicu 2025"
WORKDIR /app
COPY target/lab1-0.0.1-SNAPSHOT.jar /app/lab1-app.jar
RUN rm -rf /var/cache/apk/*
ENTRYPOINT ["java", "-jar", "lab1-app.jar"]