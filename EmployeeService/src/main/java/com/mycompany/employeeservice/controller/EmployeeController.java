package com.mycompany.employeeservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mycompany.employeeservice.entity.Employee;
import com.mycompany.employeeservice.exception.EmptyInputException;
import com.mycompany.employeeservice.service.EmployeeServiceInterface;

/**
 * 
 * @author Krish
 *
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
		
	@Autowired
	private EmployeeServiceInterface empService;
	
	/**
	 * this method saves the employee data
	 * @param employee
	 * @return
	 */
	@PostMapping("/save")
	public ResponseEntity<Employee> save(@RequestBody Employee employee) {			
		Employee emp = empService.save(employee);		
		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);		
	}
	
	@GetMapping("/emp/{empId}")
	public ResponseEntity<Employee> findById(@PathVariable("empId") Long empIdL) {
		Employee emp = empService.findByEmployeeId(empIdL);
		if(emp == null) {
			//throw new EmptyInputException("Employee data required");
		}
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> findAllEmployees() {
		List<Employee> empList = empService.findAllEmployees();
		return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<String> deleteById(@PathVariable("empId") Long empIdl) {
		empService.deleteById(empIdl);
		return new ResponseEntity<>("Record deleted", HttpStatus.OK);
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<Employee> findAllEmail(@PathVariable("email") String email ) {
		Employee emp = empService.findByEmail(email);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
	
	@PutMapping("/modify")
	public ResponseEntity<Employee> modifyEmployee(@RequestBody Employee employee) {
		Employee empl = empService.modifyEmployee(employee);
		return new ResponseEntity<Employee>(empl, HttpStatus.OK);
	}
}
