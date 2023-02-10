package com.project.motorVehicleRepairShop.web.view.model;

import com.project.motorVehicleRepairShop.data.entity.AppointmentStatus;
import com.project.motorVehicleRepairShop.data.entity.AutoRepairShop;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class AppointmentAutoRepairShopViewModel {
    private long id;
    private LocalDateTime start;
    private LocalDateTime end;
//    private String username;
    private AppointmentStatus status=AppointmentStatus.WAITING;
    private String autoRepairShopName;

}
