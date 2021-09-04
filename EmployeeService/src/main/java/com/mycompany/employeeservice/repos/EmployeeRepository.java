package com.mycompany.employeeservice.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mycompany.employeeservice.entity.Employee;

/**
 * 
 * @author Krish
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
			
	@Query("Select * from Employee where email= :email")
	public Employee findByEmail(String email);

}