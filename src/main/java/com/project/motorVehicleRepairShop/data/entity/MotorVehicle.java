package com.project.motorVehicleRepairShop.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "motor_vehicle")
public class MotorVehicle extends BaseEntity {
    @NotBlank
    @Size(min = 5, max = 20, message="Min 5, Max 20")
    private String regNum;

    @Enumerated
    private MotorVehicleLabel motorVehicleLabel;

    @NotBlank
    @Size(min = 5, max = 20, message="Min 2, Max 20")
    private String motorVehicleModel;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message="The date has to be in the past!")
    private LocalDate productionDate;


    @OneToMany(mappedBy = "motorVehicle",cascade = CascadeType.ALL)
    private List<AutoRepairShopService> autoRepairShopServices;


//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;


}
