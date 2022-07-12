package com.example.demo;

import com.example.demo.service.employee.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	DemoApplication application;

	@Value("${project.prefix}")
	private String prefix;
	@Value("${project.suffix}")
	private String suffix;

	@Test
	void generatedLoginName() {
		String login = application.hello("Mike", "Puppet");
		String expected = prefix + "Mik" + "Pup" + suffix;
		assertEquals(expected, login);
	}

}
