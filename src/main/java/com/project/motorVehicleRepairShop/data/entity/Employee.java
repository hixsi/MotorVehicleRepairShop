package com.project.motorVehicleRepairShop.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.security.auth.Subject;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee extends BaseEntity {
    @NotBlank
    @Size(min = 5, max = 20, message="Min 5, Max 20")
    private String firstName;

    @NotBlank
    @Size(min = 5, max = 20, message="Min 5, Max 20")
    private String lastName;

    @Enumerated
    private Qualification qualification;

    @ManyToOne
    @JoinColumn(name = "auto_repair_shop_id")
    private AutoRepairShop autoRepairShop;

}