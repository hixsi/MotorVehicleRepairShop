package com.project.motorVehicleRepairShop.web.view.model;

import com.project.motorVehicleRepairShop.data.entity.MotorVehicleLabel;
import com.project.motorVehicleRepairShop.data.entity.Owner;
import com.project.motorVehicleRepairShop.services.AutoRepairShopService;
import lombok.Getter;
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
public class CreateMotorVehicleViewModel {
    @NotBlank
    @Size(min = 5, max = 20, message="Min 5, Max 20")
    private String regNum;

    private Owner owner;

    @Enumerated
    private MotorVehicleLabel motorVehicleLabel;

    @NotBlank
    @Size(min = 5, max = 20, message="Min 2, Max 20")
    private String motorVehicleModel;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message="The date has to be in the past!")
    private LocalDate productionDate;


}
