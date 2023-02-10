package com.project.motorVehicleRepairShop.web.view.model;

import com.project.motorVehicleRepairShop.data.entity.MotorVehicleLabel;
import com.project.motorVehicleRepairShop.data.entity.Owner;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
public class MotorVehicleViewModel {
    private long id;
    private String regNum;
    private String ownerFirstName;
    private String ownerLastName;
    private MotorVehicleLabel motorVehicleLabel;
    private String motorVehicleModel;
    private LocalDate productionDate;
}
