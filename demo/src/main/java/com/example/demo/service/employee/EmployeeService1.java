package com.example.demo.service.employee;

import com.example.demo.entity.employee.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Profile("dev")
public class EmployeeService1 implements EmployeeService{
    @Value("${project.prefix}")
    private String prefix;
    @Value("${project.suffix}")
    private String suffix;

    private static Logger logger = LoggerFactory.getLogger(EmployeeService1.class);
    private HashMap<Long, Employee> dbEmulator = new HashMap<>();
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

    @Override
    public Employee findByName(String name) {
        if (dbEmulator.isEmpty() || name.isEmpty()) {
            return null;
        }

        Collection<Employee> employees = dbEmulator.values();

        for (Employee employee : employees) {
            if (employee.getFirstName().equals(name) || employee.getLastName().equals(name)) {
                return employee;
            }
        }

        return null;
    }

    @Override
    public boolean save(Employee employee) {
        if (dbEmulator.equals(employee)) {
            logger.info("Provided employee already exists in the db");
            return false;
        } else if (dbEmulator.containsKey(employee.getId())){
            logger.info("You can't add employee with the existing id to the db");
            return false;
        }

        dbEmulator.put(employee.getId(), employee);
        logger.info("Employee " + employee.getFirstName() + " " + employee.getLastName() + " was added to the db.");
        return true;
    }
}
