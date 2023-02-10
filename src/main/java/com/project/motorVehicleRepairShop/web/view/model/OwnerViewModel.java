package com.project.motorVehicleRepairShop.web.view.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class OwnerViewModel {
    private long id;
    private String firstName;
    private String lastName;
}
