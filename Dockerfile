FROM openjdk:21
EXPOSE 8080
ADD target/xpi-server-0.0.1-SNAPSHOT.jar xpi-server-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/xpi-server-0.0.1-SNAPSHOT.jar"]
