package com.project.motorVehicleRepairShop.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "appointment")
public class Appointment extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "auto_repair_shop_id")
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
    private AppointmentStatus status = AppointmentStatus.WAITING;









}
