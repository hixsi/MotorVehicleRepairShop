package com.project.motorVehicleRepairShop.data.repository;

import com.project.motorVehicleRepairShop.data.entity.AutoRepairShop;
import com.project.motorVehicleRepairShop.data.entity.Employee;
import com.project.motorVehicleRepairShop.data.entity.MotorVehicle;
import com.project.motorVehicleRepairShop.data.entity.MotorVehicleLabel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MotorVehicleRepository extends JpaRepository<MotorVehicle, Long> {
    List<MotorVehicle> findAllByMotorVehicleLabel(MotorVehicleLabel motorVehicleLabel);

    List<MotorVehicle> findAllByProductionDate(LocalDate productionDate);

}
