package com.project.motorVehicleRepairShop.web.view.model;

import com.project.motorVehicleRepairShop.data.entity.AppointmentStatus;
import com.project.motorVehicleRepairShop.data.entity.AutoRepairShop;
import com.project.motorVehicleRepairShop.data.entity.User;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class AppointmentViewModel {
    private long id;
    private AutoRepairShop autoRepairShop;
    private LocalDateTime start;
    private LocalDateTime end;
//    private User user;
    private AppointmentStatus status=AppointmentStatus.WAITING;

}
