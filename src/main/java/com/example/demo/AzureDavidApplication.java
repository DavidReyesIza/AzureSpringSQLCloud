package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AzureDavidApplication {
	
	@Autowired
	private EmployeeRepository repository;
	
	
	@GetMapping("/message")
	public String messasge() {
		return "Desplegado en Azure test 2ee!";
	}
	
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return repository.save(employee);
		
	}
	
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return repository.findAll();
		
	}

	public static void main(String[] args) {
		SpringApplication.run(AzureDavidApplication.class, args);
	}

}
