package com.example.demo.service.employee;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Qualifier("es2")
public class EmployeeService2 implements EmployeeService{
    @Override
    public List findAll() {
        return null;
    }

    @Override
    public String getEmployeeNickname(String first_name, String last_name) {
        return null;
    }
}
