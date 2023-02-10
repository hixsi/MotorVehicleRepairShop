package com.project.motorVehicleRepairShop.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Getter
@Setter

@ToString
@Entity
@NoArgsConstructor
@Where(clause = "deleted = 0")
@Table(name = "auto_repair_shop")
public class AutoRepairShop extends BaseEntity {

    @NotBlank
    @Size(min = 5, max = 20, message = "Min 5, Max 20")
    private String name;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "The date has to be in the past!")
    private LocalDate foundationDate;

    @OneToMany(mappedBy = "autoRepairShop", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("auto_repair_shop")
    private List<Employee> employees;

    @OneToMany(mappedBy = "autoRepairShop", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("auto_repair_shop")

    private List<AutoRepairShopService> autoRepairShopServices;

    @OneToMany(mappedBy = "autoRepairShop", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("auto_repair_shop")
    private List<Appointment> appointments;

    @Enumerated
    private MotorVehicleLabel worksWithMotorVehicleLabel;
    private int deleted = 0;





}