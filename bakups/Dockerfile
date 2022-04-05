FROM maven:3.8.4-openjdk-17-slim AS build
RUN mkdir /project
COPY . /project
WORKDIR /project
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim@sha256:565d3643a78a657ca03e85c110af9579a07e833d6bcc14f475249c521b5c5d74
RUN apt-get update -y && apt-get install dumb-init
RUN mkdir /app
RUN groupadd --system javauser && useradd -g javauser javauser
COPY --from=build /project/target/pure-awesomeness-backend-1.0.0.jar /app/backend.jar
WORKDIR /app
RUN chown -R javauser:javauser /app
USER javauser
EXPOSE 8080
CMD "dumb-init" "java" "-jar" "backend.jar"