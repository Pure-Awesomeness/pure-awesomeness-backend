FROM maven:3.8.5-openjdk-18@sha256:5dddfbf5a9f21440bf0899fdf9ca1ff3de7b3c50ee99854da95fb8277b9b3250 AS build
ENV HOME=/project
RUN mkdir -p $HOME
WORKDIR $HOME
ADD . $HOME
ENV JLINK_FLAGS=" --no-header-files --no-man-pages --compress=2 --strip-debug --output $HOME/jre "
ENV JLINK_MODULES=" --add-modules java.base,java.logging,java.sql,java.naming,java.management,java.instrument,java.desktop,java.security.jgss "
RUN jlink $JLINK_FLAGS $JLINK_MODULES
RUN --mount=type=cache,target=/root/.m2 mvn -f $HOME/pom.xml clean package

FROM debian:stretch-slim@sha256:9a5ef79eae32dab4a70da0f840b2dedd975ca06a7675b1483cfdec3a197319f1 AS stage
RUN apt-get update -y && apt-get install -y dumb-init
RUN groupadd javauser && useradd -g javauser javauser
WORKDIR /project
ARG REVISION
COPY --from=build /project/jre /project/jre
COPY --from=build /project/target/pure-awesomeness-backend-$REVISION.jar pure-awesomeness-backend.jar
RUN chown -R javauser:javauser /project
USER javauser
ENTRYPOINT ["dumb-init", "jre/bin/java","-jar","pure-awesomeness-backend.jar"]
EXPOSE 8080