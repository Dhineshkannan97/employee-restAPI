package com.example.employee.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
    public class Employee {

        private int id;
        private String name;
        private String email;
        private String phone_number;
        private  String massage;

    public String setMessage(String message) {
        return massage;
    }

    public String getMessage() {
        return massage;
    }
}