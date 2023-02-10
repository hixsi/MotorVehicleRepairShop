package com.project.motorVehicleRepairShop.services;

import com.project.motorVehicleRepairShop.data.entity.MotorVehicle;
import com.project.motorVehicleRepairShop.data.entity.MotorVehicleLabel;
import com.project.motorVehicleRepairShop.dto.AutoRepairShopDTO;
import com.project.motorVehicleRepairShop.dto.MotorVehicleDTO;
import com.project.motorVehicleRepairShop.dto.CreateMotorVehicleDTO;
import com.project.motorVehicleRepairShop.dto.UpdateMotorVehicleDTO;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.util.List;

public interface MotorVehicleService {

    List<MotorVehicleDTO> getMotorVehicles();

    MotorVehicleDTO getMotorVehicle(@Min(1) long id);

    MotorVehicle create(@Valid CreateMotorVehicleDTO createMotorVehicleDTO);

    MotorVehicle updateMotorVehicle(long id, UpdateMotorVehicleDTO updateMotorVehicleDTO);

    void deleteMotorVehicle(long id);

    List<MotorVehicleDTO> getMotorVehiclesByLabel(MotorVehicleLabel label);

    List<MotorVehicleDTO> getMotorVehiclesByProductionDate(LocalDate releaseDate);
//    List<MotorVehicleDTO> getMotorVehiclesByLabel(String label);
//    List<MotorVehicleDTO> getMotorVehiclesByLabelAndProductionDate(String label, LocalDate productionDate);

}
