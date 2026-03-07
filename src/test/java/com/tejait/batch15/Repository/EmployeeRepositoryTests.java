
package com.tejait.batch15.Repository;
import com.tejait.batch15.model.Employee;
import com.tejait.batch15.repository.EmployeeRepository;
import java.util.List;

import lombok.Data;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
@Data
@DataJpaTest
@EntityScan(basePackageClasses = Employee.class)
class EmployeeRepositoryTests {

    @Autowired
    EmployeeRepository repository;

    @Test
    void givenEmp_whenSaveEmp_thenReturnSavedEmp(){

        Employee givenEmp=Employee.builder()
                // .id(1)
                .fname("Bharat")
                .lname("p")
                .fullname("Bharat p")
                .age(22)
                .dept("java")
                .salary(100000L).empCode("ja123va")
                .build();

        Employee  savedEmp=repository.save(givenEmp);

        Assertions.assertThat(savedEmp).isNotNull();
        Assertions.assertThat(savedEmp.getId()).isPositive();
        Assertions.assertThat(savedEmp.getAge()).isGreaterThan(18);
        Assertions.assertThat(savedEmp.getDept()).isEqualTo("java");
        Assertions.assertThat(savedEmp.getFullname()).isEqualTo("Naveen M");
        Assertions.assertThat(savedEmp).hasFieldOrProperty("empCode");
        Assertions.assertThat(savedEmp).hasFieldOrPropertyWithValue("full name", "Naveen M");
        Assertions.assertThat(savedEmp).hasNoNullFieldsOrProperties();

    }


    @Test
    void givenEmployees_whenFindAll_thenReturnEmployeesList() {

        // GIVEN (prepare data)

        Employee emp1 = Employee.builder()
                .age(21)
                .fname("Manjith")
                .lname("V")
                .salary(1500000)
                .dept("Java")
                .empCode("MAN457es")
                .fullname("Manjith V")
                .build();

        Employee emp2 = Employee.builder()
                .age(25)
                .fname("Rahul")
                .lname("K")
                .salary(1200000)
                .dept("Spring")
                .empCode("RAH123xy")
                .fullname("Rahul K")
                .build();

        // save data into DB
        repository.save(emp1);
        repository.save(emp2);

        // WHEN (calling method)
        List<Employee> employeeList = repository.findAll();

        // THEN (assertions)
        Assertions. assertThat(employeeList).isNotNull();
        Assertions .assertThat(employeeList.size()).isEqualTo(2);
    }





}








