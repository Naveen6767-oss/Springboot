package com.tejait.batch15.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.tejait.batch15.model.Employee;

public interface EmployeeService {

	 public Employee saveEmployee(Employee emp);

	 public void deleteEmployee(Integer id);

	 public Optional<Employee> getById(Integer id);

	 public List<Employee> getAllEmps();

	 public Boolean existsbyid(Integer id);

	 public List<Employee> getbysortingdata(String property, String orderType);

	

	 public List<Employee> findbyid(String dept);

	 public List<Employee> getbyfullname(String fname, String lname);

	 public List<Employee> findBySalary(long salary);

	 public List<Employee> findByLastNameOrFirstName(String lname, String fname);

	 public List<Employee> findByAgeLessThan(Integer age);
     
	 public List<Employee> findByAgeLessThanEqual(Integer age);

	 public List<Employee> findByAgeGreaterThan(Integer age);

	 public List<Employee> findByFnameStartingWith(String fname);

	 public List<Employee> findByFnameEndingWith(String fname);

	 public List<String> findDistinctByDept();

	 public List<Employee> serchEmployee(String searchTerm);

	 public List<Employee> searchFilters(String filterType, String empCode);

	 public Page<Employee> getapginationData(int pageNum, int pageSize);

	

	


	

	
	 
	
	

	

	 
	 
	 

	

	 

	

	

	

	



	



	

	
	
	
}
