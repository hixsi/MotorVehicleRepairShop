package com.project.motorVehicleRepairShop.dto;

import com.project.motorVehicleRepairShop.data.entity.AppointmentStatus;
import com.project.motorVehicleRepairShop.data.entity.AutoRepairShop;
import com.project.motorVehicleRepairShop.data.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

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
@ToString
public class CreateAppointmentDTO {

    private AutoRepairShop autoRepairShop;

    @Future(message="The date has to be in the past!")
    @Column(name = "start")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime start;
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Future(message="The date has to be in the past!")
    @Column(name = "end")
    private LocalDateTime end;
    @Enumerated
    private AppointmentStatus status=AppointmentStatus.WAITING;

//    private User user;

}
