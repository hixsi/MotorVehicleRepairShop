package com.project.motorVehicleRepairShop.web.view.model;

import com.project.motorVehicleRepairShop.data.entity.MotorVehicleLabel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
public class AutoRepairShopViewModel {
    private long id;
    private String name;
    private LocalDate foundationDate;
    private MotorVehicleLabel worksWithMotorVehicleLabel;
}
