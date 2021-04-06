FROM openjdk:8 as builder

ARG SBT_VERSION=1.3.13

RUN \
  curl -sSfL -o sbt-$SBT_VERSION.deb https://dl.bintray.com/sbt/debian/sbt-$SBT_VERSION.deb && \
  dpkg -i sbt-$SBT_VERSION.deb && \
  rm sbt-$SBT_VERSION.deb && \
  apt-get update && \
  apt-get install sbt && \
  sbt sbtVersion

WORKDIR /app

COPY . .

RUN sbt assembly

FROM openjdk:8-jre-slim
WORKDIR /app
COPY --from=builder /app/target/scala-2.13/fabric8-client-test.jar .
ENTRYPOINT ["java", "-jar", "fabric8-client-test.jar"]
