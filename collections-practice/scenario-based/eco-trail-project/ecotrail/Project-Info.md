# 🌿 EcoTrail — SonarQube Integration Project

### Global Hiking Community Platform (Java • Maven • JUnit • SonarQube)

---

## 📖 Project Description

**EcoTrail** is a Java-based application that manages hiking trails across different regions.
The system records hiking activity and performs analytics such as:

* Most-hiked trails
* Difficulty-wise statistics
* Region-wise aggregation
* Trail filtering and grouping

The application makes extensive use of the **Java Collections Framework**, which makes it ideal for performing **static code quality analysis using SonarQube**.

The purpose of this project is to:

* Implement collection-based business logic
* Validate functionality using JUnit 5
* Integrate SonarQube
* Analyze code quality and test coverage

---

## 🧱 Modules

### Core Classes

| Class           | Responsibility                                          |
| --------------- | ------------------------------------------------------- |
| `Trail`         | Represents a hiking trail (Model Class)                 |
| `TrailUtil`     | Contains business logic and analytics using Collections |
| `UserInterface` | Handles console-based user interaction                  |

---

## 🚀 Functional Features

* Add trail records
* Retrieve trail by ID
* Update hike counts
* Identify most-hiked trails
* Region-wise hike aggregation
* Group trails by difficulty
* Filter trails by region
* Filter trails by difficulty
* Retrieve Top-N trails per region
* Difficulty-wise statistics

---

## 🧪 Testing

JUnit 5 test cases are written to validate all functionalities.

**Test Class**

```
TrailUtilTest.java
```

The test cases verify:

* Data insertion
* Retrieval operations
* Aggregation logic
* Filtering logic
* Analytical computations

---

## 🛠️ Technologies Used

* Java
* Maven
* JUnit 5
* SonarQube (Community Edition)
* SonarScanner for Maven
* VS Code
* Web Browser (Sonar Dashboard)

---

## ⚙️ SonarQube Integration

### Step 1 — Install and Start SonarQube

1. Download **SonarQube Community Edition**
2. Extract the downloaded folder
3. Navigate to:

```
sonarqube/bin/windows-x86-64
```

4. Start SonarQube:

```
sonar.bat start
```

5. Open in browser:

```
http://localhost:9000
```

**Login Credentials**

```
Username: admin
Password: admin
```

---

### Step 2 — Maven Project Structure

```
EcoTrail
│
├── src
│   ├── main
│   │   └── java
│   │       ├── Trail.java
│   │       ├── TrailUtil.java
│   │       └── UserInterface.java
│   │
│   └── test
│       └── java
│           └── TrailUtilTest.java
│
└── pom.xml
```

---

### Step 3 — `pom.xml` Configuration

#### Sonar Properties

```xml
<properties>
    <sonar.projectKey>ecotrail-project</sonar.projectKey>
    <sonar.host.url>http://localhost:9000</sonar.host.url>
</properties>
```

#### JUnit Dependency

```xml
<dependencies>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.9.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

#### Maven Surefire Plugin

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>3.0.0</version>
        </plugin>
    </plugins>
</build>
```

---

### Step 4 — Generate Sonar Token

1. Open SonarQube Dashboard
2. Go to:

```
My Account → Security
```

3. Generate a token
4. Copy the token

Run analysis:

```
mvn sonar:sonar -Dsonar.login=YOUR_TOKEN
```

---

### Step 5 — Execute

Run unit tests:

```
mvn clean test
```

Run SonarQube analysis:

```
mvn sonar:sonar
```

---

## 📊 SonarQube Report

After analysis, SonarQube provides:

* Bugs Detection
* Code Smells
* Maintainability Rating
* Test Coverage
* Code Duplication

### Typical Output

| Metric          | Result |
| --------------- | ------ |
| Coverage        | 64.7%  |
| Maintainability | A      |
| Critical Issues | 0      |
| Blocker Issues  | 0      |

---

## 📷 Required Screenshots

Attach screenshots of:

## 📷 Maven Test Execution
![Maven Test](images/maven-test.png)

## 📷 SonarQube Dashboard
![Sonar Dashboard](images/dashboard.png)

## 📷 Code Coverage
![Coverage](images/code-coverage.png)

---

## 🧠 Development Approach

The project was implemented using the following workflow:

1. Implement business logic
2. Validate via console execution
3. Write JUnit test cases
4. Convert project to Maven
5. Integrate SonarQube
6. Run analysis
7. Fix code smells and re-run analysis

---

## ✅ Conclusion

EcoTrail demonstrates how a Java application can be validated using **unit testing** and evaluated using **static code analysis tools**.
The integration of SonarQube helps ensure maintainable, reliable, and high-quality code.
