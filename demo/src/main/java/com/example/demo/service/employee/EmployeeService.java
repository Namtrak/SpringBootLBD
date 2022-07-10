package com.example.demo.service.employee;

import java.util.List;

public interface EmployeeService {
    List findAll();
    String getEmployeeNickname(String first_name, String last_name);
}
