package com.project.motorVehicleRepairShop.services;

import com.project.motorVehicleRepairShop.data.entity.Employee;
import com.project.motorVehicleRepairShop.data.repository.EmployeeRepository;
import com.project.motorVehicleRepairShop.dto.EmployeeAutoRepairShopDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @MockBean
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    @Test
    void getEmployeeById() {
        long employeeId = 1;

        Employee employee = new Employee();
        employee.setId(employeeId);

        Mockito.when(employeeRepository.findById(employeeId))
                .thenReturn(Optional.of(employee));

        EmployeeAutoRepairShopDTO employeeDTO = employeeService.getEmployee(employeeId);

        assertThat(employeeDTO.getId()).isEqualTo(employee.getId());
    }
}