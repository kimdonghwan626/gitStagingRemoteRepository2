FROM openjdk:11-jre-slim
ARG revision
VOLUME /tmp
COPY build/libs/gitTest2-0.0.1-SNAPSHOT-${revision}-boot.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=9999 -jar /app.jar
