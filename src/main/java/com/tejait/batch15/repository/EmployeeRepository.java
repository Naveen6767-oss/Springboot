package com.tejait.batch15.repository;



import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.tejait.batch15.model.Employee;


@CrossOrigin
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	public List<Employee> findByDept(String dept);
	
	public List<Employee> findByFnameAndLname (String fname, String lname);
	
	public List<Employee> findBySalary(long salary);
	
	public List<Employee> findByLnameOrFname(String lname, String fname);
	
	public List<Employee>findByAgeLessThan(int age);
	
	public List<Employee> findByAgeLessThanEqual(Integer age);
	
    public List<Employee> findByAgeGreaterThan(Integer age);
 
	public List<Employee> findByAgeGreaterThanEqual (Integer age);
	
	public List<Employee > findByFnameStartingWith(String fname);
	
	public List<Employee> findByFnameEndingWith(String fname);
	
	
	
	
	//public List<Employee>  findByDeptIn (Collection<String> dept);
	
	/*
	 * @Query("select e from employee e") public List<Employee> getall();
	 * 
	 * @Query(value="select * from employee_b15", nativeQuery= true) public
	 * List<Employee> getallEmps();
	 * 
	 * @Query("select e from employee e where e.dept=?1") public List<Employee>
	 * findByDepartment(String dept);
	 * 
	 * @Query("select e from employee e where e.fname=?1 and e.lname?2") public
	 * List<Employee> findByFirstNameAndLastName(String fname, String lname);
	 */
	  
	/*
	 * @Query("select e from Employee e where e.fname=:firstName And e.lname=:lastname"
	 * ) public List<Employee>
	 * findByFirstNameAndLastNameData(@Param("firstName")String
	 * fname, @Param("lastName")String lname);
	 */
	
	@Query("select distinct(e.dept) from Employee e")
	public List<String> findDistinctByDept();
	
	@Query("select e from Employee e where concat(e.fname, e.lname, e.fullname, e.dept, e.empCode, e.salary,e.age) like %?1%")
	public List<Employee> serachEmployee(String seacrhterm);
	
	/* public List<Employee> searchFilters(String serchfilters); */
	
	/*
	 * @Query("select e from Employee dept join empcode on empcode=dept") public
	 * List<Employee> findByInnerJoin(String dept, String empcode);
	 */
	
	
	//----------------------------------Search Filters Start-------------------------------------------------//
	
	public List<Employee> findByEmpCodeStartingWith(String EmpCode);
	
	public List<Employee> findByEmpCodeEndingWith(String EmpCode);
	
	public List<Employee> findByEmpCodeContaining(String EmpCode);
	  
	public List<Employee> findByEmpCodeNotContains(String EmpCode);
	
	public List<Employee> findByEmpCode(String EmpCode);
	
	public List<Employee> findByEmpCodeNot(String EmpCode);
	
	
	
	
	

	
	
		
	}
  
	


