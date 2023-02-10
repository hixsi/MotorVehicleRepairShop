package com.project.motorVehicleRepairShop.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CreateOwnerDTO {
    @NotBlank
    @Size(min = 5, max = 20, message="Min 1, Max 20")
    private String firstName;
    @NotBlank
    @Size(min = 5, max = 20, message="Min 1, Max 20")
    private String lastName;

}
