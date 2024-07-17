  **PayrollSystem-JDB**C

This project is a simple payroll management system implemented in Java. It supports adding and removing both full-time and part-time employees and calculating their salaries. 
The project uses JDBC (Java Database Connectivity) to connect to an Oracle 19c SQL database for storing and managing employee details.

   Features
- Add and remove employees (both full-time and part-time).
- Calculate and display salaries of employees.
- Store and manage employee details in an Oracle 19c SQL database using JDBC.

   Getting Started

    Prerequisites
- Java Development Kit (JDK) 8 or later.
- Oracle 19c SQL Database.
- Oracle JDBC Driver.
- Eclipse IDE (or any other Java IDE).

    Setting Up the Database
1. Install Oracle 19c and set up your database.
2. Create a table to store employee details:

   CREATE TABLE employees (
       id INT PRIMARY KEY,
       name VARCHAR2(50),
       employee_type VARCHAR2(20),
       monthly_salary NUMBER,
       hours_worked INT,
       hourly_rate NUMBER
   );
Running the Project
Clone the repository:
sh
Copy code
git clone https://github.com/Jameel-25/PayrollSystem-JDBC.git
cd PayrollSystem-JDBC
Open the project in Eclipse (or your preferred Java IDE).
Add the Oracle JDBC driver to your project's build path.
Update the database connection details in PayrollSystem.java:
java
Copy code
connection = DriverManager.getConnection(
    "jdbc:oracle:thin:@localhost:1521:orcl", "username", "password");
Run the Main.java class to start the application.
Usage
The PayrollSystem class manages employee data and interactions with the database.
The Employee class is an abstract class representing a generic employee.
The FullTimeEmployee and PartTimeEmployee classes extend Employee to represent specific types of employees.
The Main class contains example usage, including adding, removing, and displaying employees.
Contributing
Contributions are welcome! Please open an issue or submit a pull request for any improvements or bug fixes.

License
This project is licensed under the MIT License.
