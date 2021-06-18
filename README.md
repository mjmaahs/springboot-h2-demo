# springboot-h2-demo
Spring Boot H2 Demo


- After you import the project and start it, point to http://localhost:8080/h2-console/.

- Make sure that JDBC URL is jdbc:h2:C:/data/demodb then connect.

- I've created a small sql file to create a table, you can find it inside project folder main/resources/sqlfile.txt, copy the content and paste in the h2-console and run it.

- Then run localhost:8080 and you will get the data.

- Have a look at application.properties and pom.xml.

- Notice that h2 needs jdbc dependency as well found in pom.xml.