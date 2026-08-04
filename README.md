# 🏫 Staff Evaluation System

A desktop application built with Java Swing that allows students to evaluate instructors through a simple graphical interface. The application stores evaluation records in a MySQL database and provides administrators with the ability to view submitted evaluations.

This project demonstrates Java GUI development, JDBC database connectivity, and CRUD operations using MySQL.

---

## Features

- 🖥️ User-friendly Java Swing interface
- 👨‍🏫 Instructor evaluation form
- 📝 Five-point rating system
- 🏫 Department selection
- 📅 Academic year and semester input
- 💬 Additional comments
- 💾 Store evaluations in MySQL
- 📊 View submitted evaluations in a JTable
- 🧹 Clear form functionality

---

## Tech Stack

- Java
- Java Swing
- JDBC
- MySQL

---

## Installation

### Clone the repository

```bash
git clone https://github.com/sigmaCoderx/javaSwingGUI.git
cd javaSwingGUI
```

---

## Requirements

- Java JDK 8 or later
- MySQL Server
- MySQL Connector/J (JDBC Driver)

Download the MySQL JDBC Driver:

https://dev.mysql.com/downloads/connector/j/

---

## Database Setup

Create a database named:

```sql
stuffdb
```

Create a table similar to:

```sql
CREATE TABLE stuffevaluation (
    id INT AUTO_INCREMENT PRIMARY KEY,
    instName VARCHAR(100),
    stuDepartment VARCHAR(100),
    acaYear INT,
    semister VARCHAR(20),
    result VARCHAR(100),
    comment TEXT
);
```

Update the database connection inside the project if necessary.

```java
jdbc:mysql://localhost:3306/stuffdb
```

---

## Running the Application

Compile:

```bash
javac StuffEvaluationSystem.java
```

Run:

```bash
java StuffEvaluationSystem
```

---

## How It Works

1. Enter the instructor's name.
2. Select the student's department.
3. Enter the academic year and semester.
4. Rate the instructor using the five evaluation questions.
5. Enter the total score.
6. Add an optional comment.
7. Click **Submit** to save the evaluation.
8. Click **View** to display all evaluations stored in the database.

---

## Evaluation Criteria

The application evaluates instructors using five questions:

- Teaching preparation and organization
- Exam fairness
- Relevance of exam questions
- Makeup classes
- Course outline availability

Each question is rated from:

| Rating | Meaning |
|--------|---------|
| 5 | Very High |
| 4 | High |
| 3 | Moderate |
| 2 | Low |
| 1 | Very Low |

The application calculates the instructor's final rank based on the total evaluation score.

---

## Project Structure

```
javaSwingGUI/
├── StuffEvaluationSystem.java
└── README.md
```

---

## Notes

- Requires MySQL Server to be running.
- Requires the MySQL JDBC Driver.
- Database credentials are hardcoded in the source code and should be updated before use.
- Designed as a learning project for Java Swing and JDBC.

---

## Future Improvements

- User authentication
- Automatic score calculation
- Edit and delete evaluations
- Search and filter records
- Export reports to PDF or Excel
- Better UI design
- Form validation

---

## License

MIT License

---

## Author

**flippedCoin**

GitHub: https://github.com/sigmaCoderx

---

⭐ If you found this project useful, consider giving it a star on GitHub.
