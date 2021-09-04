package com.mycompany.employeeservice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.mycompany.employeeservice.entity.Employee;
import com.mycompany.employeeservice.repos.EmployeeRepository;

@SpringBootTest
@DataJpaTest
class EmployeeServiceApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private EmployeeRepository empRepo;
	
	//JUnit test for save employee
	@Test
	public void saveTest() {
		
		Employee employee = new Employee();
		employee.setFullName("Song Song");
		employee.setEmail("song@gmail.com");
		
		empRepo.save(employee);

        Assertions.assertThat(employee.getId()).isGreaterThan(0);
		
	}
	
	@Test
    public void getEmployeeTest(){

        Employee employee = empRepo.findById(1L).get();

        Assertions.assertThat(employee.getId()).isEqualTo(1L);

    }

}
