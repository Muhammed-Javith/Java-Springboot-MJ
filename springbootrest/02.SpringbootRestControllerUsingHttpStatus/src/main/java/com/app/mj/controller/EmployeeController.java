package com.app.mj.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.mj.model.Employee;

@RestController
public class EmployeeController {
	@GetMapping("/showA")
	public String showA() {
		return "Hello-String";
	}

	@GetMapping("/showB")
	public Employee showB() {
		return new Employee(22, "UDAY", 3.8);
	}

	@GetMapping("/showC")
	public List<Employee> showC() {
		return Arrays.asList(new Employee(22, "Uday", 6.8), new Employee(23, "Neha", 6.8),
				new Employee(24, "Ramu", 6.8));
	}

	@GetMapping("/showD")
	public Map<String, Employee> showD() {
		Map<String, Employee> map = new HashMap<>();
		map.put("e1", new Employee(22, "UDAY", 4.6));
		map.put("e1", new Employee(23, "NEHA", 8.2));
		map.put("e1", new Employee(24, "RAJA", 9.5));
		return map;
	}

	@GetMapping("/showE")
	public ResponseEntity<String> showE() {
		ResponseEntity<String> resp = new ResponseEntity<String>("Hello RE ", HttpStatus.OK);
		return resp;
	}
}