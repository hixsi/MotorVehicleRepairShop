package com.project.motorVehicleRepairShop.services;

import com.project.motorVehicleRepairShop.data.entity.Owner;
import com.project.motorVehicleRepairShop.dto.AutoRepairShopDTO;
import com.project.motorVehicleRepairShop.dto.CreateOwnerDTO;

import com.project.motorVehicleRepairShop.dto.OwnerDTO;
import com.project.motorVehicleRepairShop.dto.UpdateOwnerDTO;

import javax.validation.constraints.Min;
import java.util.List;

public interface OwnerService {
    List<OwnerDTO> getOwners();

    List<OwnerDTO> getAllOwnerMotorVehicles();

    Owner create(CreateOwnerDTO Owner);
    Owner updateOwner(long id, UpdateOwnerDTO updateOwnerDTO);
    OwnerDTO getOwner(@Min(1) long id);

    void deleteOwner(long id);
}
