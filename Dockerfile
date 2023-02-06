FROM openjdk:11
WORKDIR /app
ADD target/book-store-demo-0.0.1-SNAPSHOT.jar book-store-demo:0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=docker","book-store-demo-0.0.1-SNAPSHOT.jar"]

