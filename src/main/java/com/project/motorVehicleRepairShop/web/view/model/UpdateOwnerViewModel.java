package com.project.motorVehicleRepairShop.web.view.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateOwnerViewModel {
    @NotBlank
    @Size(min = 5, max = 20, message="Min 1, Max 20")
    private String firstName;
    @NotBlank
    @Size(min = 5, max = 20, message="Min 1, Max 20")
    private String lastName;
}
