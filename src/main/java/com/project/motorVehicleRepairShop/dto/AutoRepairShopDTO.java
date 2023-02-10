package com.project.motorVehicleRepairShop.dto;

import com.project.motorVehicleRepairShop.data.entity.MotorVehicleLabel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class AutoRepairShopDTO {

    private long id;
    private String name;
    private LocalDate foundationDate;
    private MotorVehicleLabel worksWithMotorVehicleLabel;

}
