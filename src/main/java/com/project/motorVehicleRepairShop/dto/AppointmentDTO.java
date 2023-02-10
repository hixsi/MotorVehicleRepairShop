package com.project.motorVehicleRepairShop.dto;

import com.project.motorVehicleRepairShop.data.entity.AppointmentStatus;
import com.project.motorVehicleRepairShop.data.entity.AutoRepairShop;
import com.project.motorVehicleRepairShop.data.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class AppointmentDTO {

    private long id;
    private AutoRepairShop autoRepairShop;
    private LocalDateTime start;
    private LocalDateTime end;
//    private User user;
    private AppointmentStatus status=AppointmentStatus.WAITING;
//    private User user;
}
