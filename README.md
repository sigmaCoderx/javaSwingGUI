# Stuff Evaluation System

A desktop application built with Java Swing and MySQL to evaluate teaching staff performance.

---

## Features

- **Evaluation Form:** Select student department, academic year, semester, and instructor name.
- **Rating System:** Rate instructors across 5 key questions using a 1 to 5 scale (Very Low to Very High).
- **View Records:** Fetch and display stored evaluation results from MySQL into an interactive table.
- **Database Integration:** Automatically saves ratings, total scores, and comments into MySQL database.

---

## Prerequisites

- **Java Development Kit (JDK 8 or higher)**
- **MySQL Database Server**
- **MySQL Connector/J (JDBC Driver)** added to project dependencies

---

## Database Setup

Run the following SQL commands in MySQL:

```sql
CREATE DATABASE stuffdb;
USE stuffdb;

CREATE TABLE stuffevaluation (
    id INT AUTO_INCREMENT PRIMARY KEY,
    instName VARCHAR(100),
    stuDepartment VARCHAR(100),
    acaYear INT,
    semister VARCHAR(50),
    result VARCHAR(50),
    comment TEXT
);
