package com.mycompany.employeeservice.service;

import java.util.List;

import com.mycompany.employeeservice.entity.Employee;

/**
 * 
 * @author Krish
 *
 */
public interface EmployeeServiceInterface {
	
	public abstract Employee save(Employee emp);
	public abstract Employee findByEmployeeId(Long id);
	public abstract void deleteById(Long id);
	public abstract Employee findByEmail(String email);
	public abstract List<Employee> findAllEmployees();
	public abstract Employee modifyEmployee(Employee emp);

}
