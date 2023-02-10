package com.project.motorVehicleRepairShop.services.implementations;

import com.project.motorVehicleRepairShop.data.entity.AutoRepairShop;
import com.project.motorVehicleRepairShop.data.entity.Employee;
import com.project.motorVehicleRepairShop.data.repository.EmployeeRepository;
import com.project.motorVehicleRepairShop.dto.*;
import com.project.motorVehicleRepairShop.exceptions.AutoRepairShopNotFoundException;
import com.project.motorVehicleRepairShop.exceptions.EmployeeNotFoundException;
import com.project.motorVehicleRepairShop.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<EmployeeAutoRepairShopDTO> getAllEmployeeAutoRepairShops() {
        return employeeRepository.findAll().stream()
                .map(this::convertToEmployeeAutoRepairShopDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Employee create(CreateEmployeeDTO employee) {
        return employeeRepository.save(modelMapper.map(employee, Employee.class));

    }

    @Override
    public Employee updateEmployee(long id, UpdateEmployeeDTO updateEmployeeDTO) {

        Employee employee = modelMapper.map(updateEmployeeDTO, Employee.class);
        employee.setId(id);


        return employeeRepository.save(employee);
    }

    @Override
    public EmployeeAutoRepairShopDTO getEmployee(long id) {
        return modelMapper.map(employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Invalid Employee Id: " + id)), EmployeeAutoRepairShopDTO.class);
    }


    @Override
    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }

    private EmployeeAutoRepairShopDTO convertToEmployeeAutoRepairShopDTO(Employee employee) {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!"+ employee.getFirstName());

        return modelMapper.map(employee, EmployeeAutoRepairShopDTO.class);
    }
}
