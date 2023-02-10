package com.project.motorVehicleRepairShop.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "auto_repair_shop_service")
public class AutoRepairShopService extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "auto_repair_shop_id")
    private AutoRepairShop autoRepairShop;
    @Enumerated
    private AutoRepairShopTypesOfService autoRepairShopTypesOfService;
    @Column
    private Double price;
    @ManyToOne
    @JoinColumn(name = "motor_vehicle_id")
    private MotorVehicle motorVehicle;


}
