package com.project.motorVehicleRepairShop.data.repository;

import com.project.motorVehicleRepairShop.data.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
