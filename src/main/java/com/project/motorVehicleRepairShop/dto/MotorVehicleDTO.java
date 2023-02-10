package com.project.motorVehicleRepairShop.dto;

import com.project.motorVehicleRepairShop.data.entity.MotorVehicleLabel;
import com.project.motorVehicleRepairShop.data.entity.Owner;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
public class MotorVehicleDTO {

        private long id;
        private String ownerFirstName;
        private String ownerLastName;
        private String regNum;
        private MotorVehicleLabel motorVehicleLabel;
        private String motorVehicleModel;
        private LocalDate productionDate;


        }
