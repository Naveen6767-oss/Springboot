package com.tejait.batch15.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.tejait.batch15.model.Employee;
import com.tejait.batch15.service.EmployeeService;

@CrossOrigin
@RestController
@RequestMapping ("/employee")
public class EmployeeController {
	

   // @Autowired
 //EmployeeService service;
	  private  final EmployeeService service;
	  
	  public EmployeeController(EmployeeService service) {
		super();
		this.service = service;
	}
	  @PostMapping("saveEmp")
	
	  public ResponseEntity<Employee> saveEmployeeEntity(@RequestBody Employee emp){
		
       Employee	savedEmp =service.saveEmployee(emp);
       
       return new ResponseEntity<>(savedEmp, HttpStatus.CREATED);
		
	}
	   @PutMapping("updateEmp")
	   public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp){
		   
		 Employee  updateEmployee=service.saveEmployee(emp);
		
		return new ResponseEntity<> (updateEmployee,HttpStatus.OK);
		   
	   }
	   
	  @DeleteMapping("deleteEmp/{id}")
	   public ResponseEntity<String> deleteEmpId(@PathVariable Integer id){
		   service.deleteEmployee(id);
		   
		return new ResponseEntity<>("delete Employee ID::  "+id, HttpStatus.OK);
		   
	   }
	   @GetMapping("getByEmpId/{id}")
	   
	   public ResponseEntity<Employee> getEmpId(@PathVariable Integer id){
		   
		 Optional<Employee> empobj =service.getById(id);
		 
		 return new ResponseEntity<>(empobj.get(),HttpStatus.OK);
		   
	   }
	   
	  @GetMapping("getAll")
	  public ResponseEntity<List<Employee>>getAllEmps(){
		  
      	List<Employee> list= service.getAllEmps();
      	
      	for(Employee emp:list) {
      		
      		System.out.println(list);
      		
      	}
      	
		return new ResponseEntity<>(list,HttpStatus.OK);
	  }
	  
	  
	  @GetMapping("/existsbyid/{id}")
	  public ResponseEntity<Boolean> existbyid(@PathVariable Integer id){
		  Boolean result= service.existsbyid(id);
		  if(Boolean.FALSE.equals(result)) {
			  
			  //throw new IdnotFoundException("Given Id NOt Found")
			  
			  //throw new AccountAlreadyExists("Account already exsist exception")
			  
		  }
		  
		return new ResponseEntity<> (result,HttpStatus.OK);
		  
		  
	  }
		/*
		 * @GetMapping("pagination") public ResponseEntity<Page<Employee>>
		 * paginationData(@RequestParam int pageNum, @RequestParam int pageSize){
		 * Page<Employee> page= service.getapginationData(pageNum, pageSize); return new
		 * ResponseEntity<>(page, HttpStatus.OK);
		 */
		  
	 // }
	  
	  @GetMapping("dataSorting")
	  
	  public ResponseEntity<List<Employee>>  dataSorting(@RequestParam String property, @RequestParam String orderType){
		  
		   List<Employee>  sort =service.getbysortingdata(property,orderType );
		  
		return new ResponseEntity<>(sort,HttpStatus.OK) ;
		  
		  
	  }
	  
	       @GetMapping("findbydept/{dept}")
	       
		  public ResponseEntity<Employee> findbydept(@PathVariable String dept){
			  
			                       List<Employee> id = service.findbyid(dept);
			                       
								   return new ResponseEntity<> (HttpStatus.OK);
			  
			  
		  }
	       @GetMapping("Findbyfullname")
	       public ResponseEntity<List<Employee>> findbyname(@RequestParam String fname, @RequestParam String lname){
	    	   
	    	   List<Employee> list =service.getbyfullname(fname,lname);
	    	   
	    	   
			return new ResponseEntity<> (list, HttpStatus.OK);
	    	   
	    	   
	       }
	       @GetMapping("findBySalary/{salary}")
	       public ResponseEntity<List<Employee>> findbysalary(@PathVariable long salary){
	    	   
	    	   List<Employee> list =service.findBySalary(salary);
	    	   
	    	   return new ResponseEntity<> (list, HttpStatus.OK);
	    	   
	       }
	       
	       
	         @GetMapping("findByLastNameOrFirstName")
	    	public ResponseEntity<List<Employee>>  findByLastNameOrFirstName(@RequestParam String lname, @RequestParam String fname){
	        	 
	        	List<Employee> list=service.findByLastNameOrFirstName(lname, fname);
	    		
	    		
				return new ResponseEntity<>(list,HttpStatus.OK);
	    		
	    		
	    	}
	      
	         
	         
	         
	         @GetMapping("findByAgeLessthan/{age}")
	         public ResponseEntity<List<Employee>> findByAgeLessthan(@PathVariable int age){
	        List<Employee>	list=service.findByAgeLessThan(age);
	        
	        return new ResponseEntity<>(list, HttpStatus.OK);
	      	 
	         }
	         
	         
	         @GetMapping("findByAgeLessThanEquals")
	         public ResponseEntity<List<Employee>> findByAgeLessThanEqual(@RequestParam int age){
	        	 
	        	 List<Employee> list = service.findByAgeLessThanEqual(age);
	        	 
				return new ResponseEntity<> (list, HttpStatus.OK);
				 
	         }
	         @GetMapping("findByAgeGreaterThanEqual")
	         public ResponseEntity<List<Employee>> findByAgeGreaterThanEqual (@RequestParam int age){
	        	  
	        	 List<Employee> list= service.findByAgeLessThanEqual(age);
	        	 
	        	 return new ResponseEntity<> (list, HttpStatus.OK);
	        	 
	         }
	         @GetMapping("findByAgeGreaterThan")
	         public ResponseEntity<List<Employee>> findByAgeGreaterThan(@RequestParam int age){
	        	 
	        	        List<Employee>  list=service.findByAgeGreaterThan(age);
	        	        
				return new ResponseEntity<> (list, HttpStatus.OK);
	        	 
	        	 
	         }
	         @GetMapping("findByFnameStartingWith")
	         public ResponseEntity<List<Employee>> findByFnameStartingWith (@RequestParam String fname){
	        	 
	        	     List<Employee>   list = service.findByFnameStartingWith(fname);
	        	     
	        	     return new ResponseEntity<> (list, HttpStatus.OK);
	        	        	        	        
	         }
	         
	         @GetMapping("findbyfnameendingwith/{fname}")
	          public ResponseEntity<List<Employee>> findByFnameEndingWith (@PathVariable String fname){
	    	  
	    	                       List<Employee>      list = service.findByFnameEndingWith(fname);
	   
                         return new ResponseEntity<> (list , HttpStatus.OK); 	
                         
	         }       
                   @GetMapping("finddistinctbydept")      
                    public ResponseEntity<List<String>>    findDistinctByDept(){
                    	
                    List<String>	list1=service.findDistinctByDept();
                    
                    return new ResponseEntity<>(list1, HttpStatus.OK);
                    }
                   @GetMapping("search/{searchterm}")
                   public ResponseEntity<List<Employee>> searchdata(@PathVariable String searchterm){
                	   
                	List<Employee> list = service.serchEmployee(searchterm);
                	
                	
                	return new ResponseEntity<> (list, HttpStatus.OK);
                   }
                                   	   
                   
                   
                   @GetMapping("searchFilters")
                   public ResponseEntity<List<Employee>> searchFilters(@RequestParam String filterType, @RequestParam String empCode){
                	   
                	   List<Employee>   list= service.searchFilters(filterType,empCode );
                	   
                	   return new ResponseEntity<> (list, HttpStatus.OK); 
                	   
                   }
                   
                   
                	   
                	   
                   }	    	  
	    	  
	      

	        
	     
	        
	    
	        
	         
				
			
	    	   
	    	   
	    	   
   
	    	   
	    	   
	       
	       
		
		  
		  
	
	  
	  
	  

	  
		 
		
		  
		  
		  
		  
		  
		  
		
		  
		  
	  
	
		  
	  
	   

	  
	  
	
	   
	   		
	
	
	
	
	


