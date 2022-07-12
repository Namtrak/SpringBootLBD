package com.example.demo.service.employee;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface EmployeeService {
    List findAll();
    String getEmployeeNickname(String first_name, String last_name);
}
