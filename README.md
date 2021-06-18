# springboot-h2-demo
- A Spring Boot H2 Demo


# git repo
- git clone https://github.com/mjmaahs/springboot-h2-demo.git
- cd springboot-h2-demo


# packaging the app
- mvn clean package

# Runing the app
- cd target
- java -jar demo-0.0.1-SNAPSHOT.jar


# do test cases and generate jacoco reports
- mvn test
- mvn jacoco:report
- cd \target\site\jacoco

# UML file
- \src\main\java\com\example\demo\DemoUML.ucls

# OpenAPI 3 specification docs
http://localhost:8080/v3/api-docs/
