package com.tejait.batch15.serviceimpl;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.tejait.batch15.Constants.SearchFilter;
import com.tejait.batch15.model.Employee;
import com.tejait.batch15.repository.EmployeeRepository;
import com.tejait.batch15.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository repository;

	@Override
	public Employee saveEmployee(Employee emp) {

		String fname = emp.getFname();
		String lname = emp.getLname();
		emp.setFullname(fname.concat(" " + lname));
		return repository.save(emp);
	}

	@Override
	public void deleteEmployee(Integer id) {

		repository.deleteById(id);

	}

	@Override
	public Optional<Employee> getById(Integer id) {

		return repository.findById(id);

	}

	@Override
	public List<Employee> getAllEmps() {

		// return repository.getall();

		return repository.findAll();

	}

	@Override
	public Boolean existsbyid(Integer id) {

		return repository.existsById(id);
	}

	@Override

	public Page<Employee> getapginationData(int pageNum, int pageSize) {

		Pageable pageable = PageRequest.of(pageNum, pageSize);

		return repository.findAll(pageable);
	}

	@Override
	public List<Employee> getbysortingdata(String property, String orderType) {

		if (orderType.equalsIgnoreCase("desc")) {

			return repository.findAll(Sort.by(Direction.DESC, property));
		}

		return repository.findAll(Sort.by(Direction.ASC, property));

	}

	@Override
	public List<Employee> findbyid(String dept) {

		return repository.findByDept(dept);
	}

	@Override
	public List<Employee> getbyfullname(String fname, String lname) {

		return repository.findByFnameAndLname(fname, lname);
	}

	@Override
	public List<Employee> findBySalary(long salary) {

		return repository.findBySalary(salary);
	}

	@Override
	public List<Employee> findByLastNameOrFirstName(String lname, String fname) {

		return repository.findByLnameOrFname(lname, fname);
	}

	@Override
	public List<Employee> findByAgeLessThan(Integer age) {

		return repository.findByAgeLessThan(age);
	}

	@Override
	public List<Employee> findByAgeLessThanEqual(Integer age) {

		return repository.findByAgeLessThanEqual(age);
	}

	@Override
	public List<Employee> findByAgeGreaterThan(Integer age) {

		return repository.findByAgeGreaterThanEqual(age);
	}

	@Override
	public List<Employee> findByFnameStartingWith(String fname) {

		return repository.findByFnameAndLname(fname, fname);
	}

	@Override
	public List<Employee> findByFnameEndingWith(String fname) {

		return repository.findByFnameEndingWith(fname);
	}

	@Override
	public List<String> findDistinctByDept() {
		
		return repository.findDistinctByDept();
	}

	@Override
	public List<Employee> serchEmployee(String searchTerm) {
		
		return repository.serachEmployee(searchTerm);
	}

	@Override
	public List<Employee> searchFilters(String filterType, String empCode) {
		List<Employee> list=null;
		
		switch (filterType) {
		
		case SearchFilter.EQUALS:
			list=repository.findByEmpCode(empCode);
			break;
			
		case SearchFilter.NOT_EQUALS:
			
			list=repository.findByEmpCodeNot(empCode);
			break;
			
		case SearchFilter.NOT_CONTAINS:
			
			list=repository.findByEmpCodeNot(empCode);
			break;
			
		case SearchFilter.START_WITH:
			
			list= repository.findByEmpCodeStartingWith(empCode);
			
			break;
			
		case SearchFilter.END_WITH:
			
			list =repository.findByEmpCodeEndingWith(empCode);
			break;
			
		case SearchFilter.CONTAINS:
			list= repository.findByEmpCodeContaining(empCode);
			break;
			
			default :
				
				throw new IllegalArgumentException("Unexpected Value:"+ filterType);
		}
		
		return list;
		
	}

	}


	/*
	 * @Override public List<Employee> findByDeptIn(List<String> dept) {
	 * 
	 * return repository.findByDeptIn(dept);
	 * 
	 * }
	 */



