package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		return "Desplegado en Azure test preubaaaaa sieee!";
	}
	
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return repository.save(employee);
		
	}
	
	@PutMapping("/employee/{id}")
	public Employee editEmployee(@RequestBody Employee employee,@PathVariable Integer id) {
		Employee empleadoActual = repository.findById(id).orElse(null);
		empleadoActual.setName(employee.getName());
		empleadoActual.setDept(employee.getDept());
		empleadoActual.setSalary(employee.getSalary());
		Employee empleadoUpdated = null;

		empleadoUpdated = repository.save(empleadoActual);
	
		return empleadoUpdated;
	}
	
	@DeleteMapping("/employee/{id}")
	public void editEmployee(@PathVariable Integer id) {
		repository.deleteById(id);
		
	}

	
	
	
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return (List<Employee>) repository.findAll();
		
	}
	
	@GetMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable Integer id) {
		
		return repository.findById(id).orElse(null);
	}

	public static void main(String[] args) {
		SpringApplication.run(AzureDavidApplication.class, args);
	}

}
