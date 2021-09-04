package com.mycompany.employeeservice.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mycompany.employeeservice.entity.Employee;
import com.mycompany.employeeservice.exception.EmptyInputException;
import com.mycompany.employeeservice.repos.EmployeeRepository;

/**
 * 
 * @author Krish
 *
 */
@Service
public class EmployeeService implements EmployeeServiceInterface {
	
	Logger empLog = LoggerFactory.getLogger(EmployeeService.class);
	
	@Autowired
	private EmployeeRepository empRepository;
	
	@Override
	/**
	 * save employee to database
	 */
	public Employee save(Employee empl) {
		
		if (empl.getFullName().isEmpty()) {
			empLog.error("Employee object is null");
			//throw new EmptyInputException("Employee data required, please check");
		}
		
		Employee emp = empRepository.save(empl);
		return emp;
	}
	
	public Employee findByEmployeeId(Long id) {
		Employee emp = empRepository.findById(id).get();
		return emp;
	}
	
	public List<Employee> findAllEmployees() {
		return empRepository.findAll();
	}
	
	public void deleteById(Long id) {
		empRepository.deleteById(id);
	}
	
	public Employee findByEmail(String email) {
		return empRepository.findByEmail(email);
	}
	
	public Employee modifyEmployee(Employee emp) {
		Employee empl = this.findByEmployeeId(emp.getId());
		empl.setFullName("Sam Song");
		empl.setEmail(emp.getEmail());
		return this.save(empl);
	}

}
