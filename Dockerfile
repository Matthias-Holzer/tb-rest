FROM eclipse-temurin:18-jre
COPY ./src/main/resources/sample-data.txt src/main/resources/sample-data.txt
COPY ./target/tb-rest-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
