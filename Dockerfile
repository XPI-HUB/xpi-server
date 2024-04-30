# FROM openjdk:21
# EXPOSE 8080
# ADD target/springboot-images-new.jar springboot-images-new.jar
# ENTRYPOINT ["java","-jar","/springboot-images-new.jar"]
# # Use a base image with Java 11
FROM openjdk:21
WORKDIR /app
COPY target/your-application.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
