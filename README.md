# springboot-h2-demo
Spring Boot H2 Demo


1- User java -jar
mvn clean
mvn compile
mvn test
mvnw package
cd target
java -jar demo-0.0.1-SNAPSHOT.jar


2- Spring Boot Maven pluginf
./mvnw package						mvn package
./mvnw spring-boot:run				mvn spring-boot:run

3- generate reports
mvn test
mvn jacoco:report