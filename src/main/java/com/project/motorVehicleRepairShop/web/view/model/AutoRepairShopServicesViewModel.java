package com.project.motorVehicleRepairShop.web.view.model;

import com.project.motorVehicleRepairShop.data.entity.AutoRepairShop;
import com.project.motorVehicleRepairShop.data.entity.AutoRepairShopTypesOfService;
import com.project.motorVehicleRepairShop.data.entity.MotorVehicle;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AutoRepairShopServicesViewModel {
    private long id;
    private AutoRepairShop autoRepairShop;
    private AutoRepairShopTypesOfService autoRepairShopTypesOfService;
    private Double price;
    private MotorVehicle motorVehicle;
}
