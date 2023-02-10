package com.project.motorVehicleRepairShop.dto;

import com.project.motorVehicleRepairShop.data.entity.AutoRepairShop;
import com.project.motorVehicleRepairShop.data.entity.Qualification;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class EmployeeAutoRepairShopDTO {
    private long id;
    private String firstName;
    private String lastName;
    private Qualification qualification;
    private String autoRepairShopName;
}
