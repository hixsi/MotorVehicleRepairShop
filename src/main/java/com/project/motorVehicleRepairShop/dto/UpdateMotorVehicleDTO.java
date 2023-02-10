package com.project.motorVehicleRepairShop.dto;

import com.project.motorVehicleRepairShop.data.entity.MotorVehicleLabel;
import com.project.motorVehicleRepairShop.data.entity.Owner;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateMotorVehicleDTO {

    private String regNum;
    private Owner owner;
    private MotorVehicleLabel motorVehicleLabel;
    private String motorVehicleModel;
    private LocalDate productionDate;
}
