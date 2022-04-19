FROM openjdk:11
ADD target/*.jar customer-app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","customer-app.jar"]