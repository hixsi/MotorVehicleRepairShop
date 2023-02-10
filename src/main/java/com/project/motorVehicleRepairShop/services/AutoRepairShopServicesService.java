package com.project.motorVehicleRepairShop.services;

import com.project.motorVehicleRepairShop.data.entity.AutoRepairShopService;
import com.project.motorVehicleRepairShop.data.entity.AutoRepairShopTypesOfService;
import com.project.motorVehicleRepairShop.data.entity.Employee;
import com.project.motorVehicleRepairShop.data.entity.MotorVehicleLabel;
import com.project.motorVehicleRepairShop.dto.*;

import java.util.List;

public interface AutoRepairShopServicesService {
    List<AutoRepairShopServicesMotorVehicleDTO> getAllServicesMotorVehicles();

    AutoRepairShopService create(CreateAutoRepairShopServicesDTO service);

    List<AutoRepairShopServicesMotorVehicleDTO> getServicesByType(AutoRepairShopTypesOfService type);
}
