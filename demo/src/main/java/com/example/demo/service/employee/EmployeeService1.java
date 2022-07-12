package com.example.demo.service.employee;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Qualifier("es1")
@Primary
public class EmployeeService1 implements EmployeeService{
    @Value("${project.prefix}")
    private String prefix;
    @Value("${project.suffix}")
    private String suffix;

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public String getEmployeeNickname(String first_name, String last_name) {
        return prefix + first_name.substring(0, 3) + last_name.substring(0, 3) + suffix;
    }
}
