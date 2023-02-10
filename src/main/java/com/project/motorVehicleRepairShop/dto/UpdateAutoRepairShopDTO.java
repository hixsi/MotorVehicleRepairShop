package com.project.motorVehicleRepairShop.dto;

import com.project.motorVehicleRepairShop.data.entity.MotorVehicleLabel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateAutoRepairShopDTO {


    private String name;
    private LocalDate foundationDate;
    private MotorVehicleLabel worksWithMotorVehicleLabel;
}
