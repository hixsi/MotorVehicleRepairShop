package com.project.motorVehicleRepairShop.dto;

import com.project.motorVehicleRepairShop.data.entity.AutoRepairShop;
import com.project.motorVehicleRepairShop.data.entity.AutoRepairShopTypesOfService;
import com.project.motorVehicleRepairShop.data.entity.MotorVehicle;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Getter
@Setter
@NoArgsConstructor
public class AutoRepairShopServicesDTO {
    private long id;
    private AutoRepairShop autoRepairShop;
    private AutoRepairShopTypesOfService autoRepairShopTypesOfService;
    private Double price;
    private MotorVehicle motorVehicle;
}
