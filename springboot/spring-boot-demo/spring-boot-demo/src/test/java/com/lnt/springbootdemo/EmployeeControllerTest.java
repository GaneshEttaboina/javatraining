package com.lnt.springbootdemo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.lnt.springbootdemo.day3.Employee;
import com.lnt.springbootdemo.day3.EmployeeRepository;
import com.lnt.springbootdemo.day3.EmpController;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest
{
    @InjectMocks
    EmpController employeeController;

    @Mock
    EmployeeRepository employeeDAO;

    @Test
    public void testAddEmployee()
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        when(employeeDAO.save(any(Employee.class))).thenReturn(new Employee(1, "Lokesh", 34343));

        Employee employee = new Employee(1, "Lokesh", 34343);
        ResponseEntity<Void> responseEntity = employeeController.createEmployee(employee);

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
//        assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");
    }

    @Test
    public void testFindAll() {
        Employee employee1 =  new Employee(1, "Lokesh", 34343);
        Employee employee2 = new Employee(2, "Alex", 33434.34);
        List<Employee> employees = new ArrayList<>();
//        employees.addAll(Arrays.asList(employee1, employee2));
        employees.add(employee1);
        employees.add(employee2);

        when(employeeDAO.findAll()).thenReturn(employees);

        List<Employee> result = employeeController.getEmployees();

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getName()).isEqualTo(employee1.getName());
        assertThat(result.get(1).getName()).isEqualTo(employee2.getName());
    }
}