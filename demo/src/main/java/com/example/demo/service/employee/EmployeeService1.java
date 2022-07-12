package com.example.demo.service.employee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Profile("dev")
public class EmployeeService1 implements EmployeeService{
    Logger logger = LoggerFactory.getLogger(EmployeeService1.class);
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
        logger.info("Provided first and last name: " + first_name + " " + last_name);
        String result = prefix + first_name.substring(0, 3) + last_name.substring(0, 3) + suffix;
        logger.info("The result of function: " + result);

        return result;
    }
}
