package com.project.motorVehicleRepairShop.web.view.model;

import com.project.motorVehicleRepairShop.data.entity.AutoRepairShop;
import com.project.motorVehicleRepairShop.data.entity.Qualification;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CreateEmployeeViewModel {
    @NotBlank
    @Size(min = 5, max = 20, message="Min 5, Max 20")
    private String firstName;
    @NotBlank
    @Size(min = 5, max = 20, message="Min 5, Max 20")
    private String lastName;
    private Qualification qualification;
    private AutoRepairShop autoRepairShop;
}
