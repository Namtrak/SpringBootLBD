package com.example.demo;

import com.example.demo.entity.employee.Employee;
import com.example.demo.service.employee.EmployeeService;
import com.example.demo.service.employee.EmployeeService1;
import org.apache.catalina.core.ApplicationContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.Assert;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("dev")
class DemoApplicationTests {
	@Value("${project.prefix}") private String prefix;
	@Value("${project.suffix}") private String suffix;

	@Autowired
	DemoApplication demoApplication;

	@Autowired
	EmployeeService employeeService;

//	@Test
//	void generatedLoginName() {
//		String login = demoApplication.hello("Mike", "Puppet");
//		String expected = prefix + "Mik" + "Pup" + suffix;
//		assertEquals(expected, login);
//	}

	@Test
	void testAddAndFind(){
		Employee employee1 = new Employee(1L, "Mateo", "Jolero", 1237890L, 135791L, 123123L);
		assertTrue(employeeService.save(employee1));
		assertEquals(employee1, employeeService.findByName("Mateo"));
	}

}
