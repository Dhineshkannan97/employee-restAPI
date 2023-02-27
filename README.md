# employee-restAPI
This project is a simple Employee Management System built using the Spring Boot framework. It provides endpoints to perform CRUD operations on employee data.

Requirements
Java 8 or higher
Maven 3.6.0 or higher
Getting Started
To run the application, navigate to the project directory and execute the following command:

mvn spring-boot:run
This will start the application on port 9092.


Get All Employees:

GET /employees
Returns a list of all employees in the system.

Get Employee by ID:

GET /employees/{id}
Returns the employee with the specified ID.

Add Employee:

POST /employees
Adds a new employee to the system. The employee data must be provided in the request body in JSON format.

Delete Employee:

DELETE /employees?id={id}
Deletes the employee with the specified ID.

Conclusion
This is a simple example of how to use the Spring Boot framework to build a RESTful API. With this basic structure in place, additional functionality and endpoints can be added to meet the requirements of a more complex application.
