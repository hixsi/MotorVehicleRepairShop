package com.project.motorVehicleRepairShop.dto;

import com.project.motorVehicleRepairShop.data.entity.AppointmentStatus;
import com.project.motorVehicleRepairShop.data.entity.AutoRepairShop;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor

public class AppointmentAutoRepairShopDTO {

    private long id;
    private LocalDateTime start;
    private LocalDateTime end;
//    private String username;
    private AppointmentStatus status=AppointmentStatus.WAITING;
    private String autoRepairShopName;

}
