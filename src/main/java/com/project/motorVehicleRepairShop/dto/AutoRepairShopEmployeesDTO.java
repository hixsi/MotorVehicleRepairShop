package com.project.motorVehicleRepairShop.dto;

import com.project.motorVehicleRepairShop.data.entity.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class AutoRepairShopEmployeesDTO {
    private long id;
    private String name;
    private LocalDate foundationDate;
    private List<Employee> employees;
}
