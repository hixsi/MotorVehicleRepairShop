package com.project.motorVehicleRepairShop.services;

import com.project.motorVehicleRepairShop.data.entity.AutoRepairShop;
import com.project.motorVehicleRepairShop.data.entity.Employee;
import com.project.motorVehicleRepairShop.dto.*;

import javax.validation.constraints.Min;
import java.util.Arrays;
import java.util.List;

public interface EmployeeService {
    List<EmployeeAutoRepairShopDTO> getAllEmployeeAutoRepairShops();

    Employee create(CreateEmployeeDTO employee);
    Employee updateEmployee(long id, UpdateEmployeeDTO updateEmployeeDTO);
    EmployeeAutoRepairShopDTO getEmployee(@Min(1) long id);

    void deleteEmployee(long id);


}

