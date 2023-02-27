package com.example.employee.controller;

import com.example.employee.model.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@SpringBootApplication

@RestController
public class EmployeeController {
    private List<Employee> employees = new ArrayList<>();

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable("id") int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    @PostMapping("/employees")
    public String addEmployee(@RequestBody String requestBody) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Employee newEmployee = objectMapper.readValue(requestBody, Employee.class);
            employees.add(newEmployee);
            return "Employee added successfully with ID: " + newEmployee.getId();
        } catch (IOException e) {
            e.printStackTrace();
            return "Error adding employee";
        }
    }

    @DeleteMapping("/employees")
    public String deleteEmployeeById(@RequestParam("id") int id) {
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getId() == id) {
                iterator.remove();
                return "Employee with ID " + id + " has been removed";
            }
        }
        return "Employee with ID " + id + " not found";
    }    @PostMapping("/send-message")
    public String sendMessage(@RequestParam("phone_number") String phoneNumber, @RequestParam("message") String message) {
        for (Employee employee : employees) {
            if (employee.getPhone_number().equals(phoneNumber)) {
                employee.setMessage(message);
                return "Message set for employee with phone number " + phoneNumber;
            }
        }
        return "Employee with phone number " + phoneNumber + " not found";
    }

    @GetMapping("/messages/{phone_number}")
    public String getMessageByPhoneNumber(@PathVariable("phone_number") String phoneNumber) {
        for (Employee employee : employees) {
            if (employee.getPhone_number().equals(phoneNumber)) {
                return employee.getMessage();
            }
        }
        return "Message not found for employee with phone number " + phoneNumber;
    }
}
