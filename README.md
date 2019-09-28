# Keep-Accountable
Open Banking Hackathon

Requirements:
* Mongodb (default installation)

Buiding the Application:
For Windows
```
.\mvnw.cmd package -DskipTests
```

For Linux
```
.\mvnw package -DskipTests
```

The build produce excutable jar under target directory.

To Run:
```
java -jar target/keepaccountable-0.0.1-SNAPSHOT.jar
```