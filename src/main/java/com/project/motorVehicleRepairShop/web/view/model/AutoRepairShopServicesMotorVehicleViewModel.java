package com.project.motorVehicleRepairShop.web.view.model;

import com.project.motorVehicleRepairShop.data.entity.AutoRepairShopTypesOfService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AutoRepairShopServicesMotorVehicleViewModel {
    private long id;
    private String autoRepairShopName;
    private AutoRepairShopTypesOfService autoRepairShopTypesOfService;
    private Double price;
    private String motorVehicleLabel;
    private String motorVehicleModel;
    private String motorVehicleRegNum;
}
