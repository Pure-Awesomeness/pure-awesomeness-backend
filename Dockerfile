FROM amazoncorretto:17-alpine3.15-jdk
RUN apk update && apk add dumb-init
RUN mkdir /app
RUN addgroup -S javauser && adduser -S javauser -G javauser
COPY ./target/pure-awesomeness-backend-1.0.0.jar /app/pure-awesomeness-backend.jar
WORKDIR /app
RUN chown -R javauser:javauser /app
USER javauser
CMD "dumb-init" "java" "-jar" "pure-awesomeness-backend.jar"
EXPOSE 8080
