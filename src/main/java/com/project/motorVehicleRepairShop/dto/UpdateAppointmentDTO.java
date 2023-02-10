package com.project.motorVehicleRepairShop.dto;

import com.project.motorVehicleRepairShop.data.entity.AppointmentStatus;
import com.project.motorVehicleRepairShop.data.entity.AutoRepairShop;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.validation.constraints.Future;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateAppointmentDTO {
    private long id;
    private AutoRepairShop autoRepairShop;

    @Future(message="The date has to be in the past!")
    @Column(name = "start")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime start;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Future(message="The date has to be in the past!")
    @Column(name = "end")
    private LocalDateTime end;
    @Enumerated
    private AppointmentStatus status;
}
