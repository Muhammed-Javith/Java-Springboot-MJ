package com.app.mj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.mj.model.Employee;
import com.app.mj.service.IEmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Controller
@RequestMapping("/rest/employee")
@Tag(name = "Demo", description = "Demo API")
public class EmployeeController {

	@Autowired
	private IEmployeeService service;

//1. save student data
	@Operation(summary = "To create Employee data")
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Employee employee) {
		ResponseEntity<String> resp = null;
		try {
			Integer id = service.saveEmployee(employee);
			resp = new ResponseEntity<String>("Employee '" + id + "' created", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}

//2. get All Records
	@Operation(summary = "To get All Employee data")
	@GetMapping("/all")
	public ResponseEntity<?> getAll() {
		ResponseEntity<?> resp = null;
		List<Employee> list = service.getAllEmployees();
		if (list == null || list.isEmpty()) {
			String message = "No Data Found";
			resp = new ResponseEntity<String>(message, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
		}
		return resp;
	}

	// 3. delete based on id , if exist
	@Operation(summary = "To delete particular Employee data")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id) {
		ResponseEntity<String> resp = null;
		// check for exist
		boolean present = service.isPresent(id);
		if (present) {
			// if exist
			service.deleteEmployee(id);
			resp = new ResponseEntity<String>("Deleted '" + id + "' successfully", HttpStatus.OK);
		} else { // not exist
			resp = new ResponseEntity<String>("'" + id + "' Not Exist", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}

	// 4. update data
	@Operation(summary = "To update particular Employee data")
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Employee employee) {
		ResponseEntity<String> resp = null;
		// check for id exist
		boolean present = service.isPresent(employee.getEmpId());
		if (present) { // if exist
			service.updateEmployee(employee);
			resp = new ResponseEntity<String>("Updated Successfully", HttpStatus.OK);
		} else {
			// not exist
			resp = new ResponseEntity<String>("Record '" + employee.getEmpId() + " ' not found",
					HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
}