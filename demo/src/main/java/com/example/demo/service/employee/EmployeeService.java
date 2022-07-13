package com.example.demo.service.employee;

import com.example.demo.entity.employee.Employee;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public interface EmployeeService {
    Map<Object, Object> dbEmulator = null;
    List findAll();
    String getEmployeeNickname(String first_name, String last_name);
    Employee findByName(String name);
    void save(Employee employee);
}
