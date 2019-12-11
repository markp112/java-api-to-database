//package io.nology.springbootreference.dao;
//
//import io.nology.springbootreference.entity.Employee;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.*;
//
////@DataJpaTest
//@SpringBootTest
//@RunWith(SpringRunner.class)
//public class EmployeeRepositoryTest {
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Autowired
//    private EmployeeRepository employeeRepository;
//
//    //    @BeforeAll
////    public void spinUpDatabaseContent() {
////        Employee ollie = new Employee("Ollie", "Holden", "ollie@me.com");
////        Employee shea = new Employee("Shea", "Murphy", "shea@him.com");
////        entityManager.persistAndFlush(ollie);
////        entityManager.persistAndFlush(shea);
////    }
//
//    @Test
//    public void findAllReturnsAListOfEmployeesInTheDatabase() {
//        // Given
//        Employee ollie = new Employee("Ollie", "Holden", "ollie@me.com");
//        Employee shea = new Employee("Shea", "Murphy", "shea@him.com");
//        entityManager.persistAndFlush(ollie);
//        entityManager.persistAndFlush(shea);
//
//        // When
//        List<Employee> foundEmployees = employeeRepository.findAll();
//
//        // Then
//        assertThat(foundEmployees).containsExactly(ollie, shea);
//    }
//}
