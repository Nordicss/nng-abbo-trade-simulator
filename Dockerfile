FROM openjdk:17-oracle
EXPOSE 8080
ADD target/nng-abbo-trade-simulator-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
