# springboot-h2-demo
Spring Boot H2 Demo


# git repo
git clone https://github.com/mjmaahs/springboot-h2-demo.git
cd springboot-h2-demo


# packaging and runing the app
mvn clean package
cd target
java -jar demo-0.0.1-SNAPSHOT.jar


# do test cases and generate jacoco reports
mvn test
mvn jacoco:report
cd \target\site\jacoco