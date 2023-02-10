package com.project.motorVehicleRepairShop.data.repository;

import com.project.motorVehicleRepairShop.data.entity.AutoRepairShopService;
import com.project.motorVehicleRepairShop.data.entity.AutoRepairShopTypesOfService;
import com.project.motorVehicleRepairShop.data.entity.MotorVehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AutoRepairShopServicesRepository extends JpaRepository<AutoRepairShopService, Long> {

    List<AutoRepairShopService> findAllByAutoRepairShopTypesOfService(AutoRepairShopTypesOfService type);
}
