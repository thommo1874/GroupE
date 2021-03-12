FROM openjdk:latest
COPY ./target/GroupE-0.1.0.3-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "GroupE-0.1.0.3-jar-with-dependencies.jar"]
