package com.project.motorVehicleRepairShop.services;

import com.project.motorVehicleRepairShop.data.entity.*;
import com.project.motorVehicleRepairShop.dto.AutoRepairShopDTO;
import com.project.motorVehicleRepairShop.dto.CreateAutoRepairShopDTO;
import com.project.motorVehicleRepairShop.dto.UpdateAutoRepairShopDTO;
import org.springframework.data.domain.Sort;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface AutoRepairShopService {
    List<AutoRepairShopDTO> getAutoRepairShops();

    AutoRepairShopDTO getAutoRepairShop(@Min(1) long id);

    AutoRepairShop create(@Valid CreateAutoRepairShopDTO createAutoRepairShopDTO);

    AutoRepairShop updateAutoRepairShop(long id, UpdateAutoRepairShopDTO updateAutoRepairShopDTO);

    void deleteAutoRepairShop(long id);

    List<AutoRepairShopDTO> getAutoRepairShopsByName(String name);

    List<Employee> getAllEmployeesByAutoRepairShopId(long id);

    List<AutoRepairShopDTO> getAutoRepairShopsByNameContainingOrderByName(String substringName);

    List<AutoRepairShopDTO> getAutoRepairShopsByNameContainingOrderByNameDesc(String substringName);

    List<AutoRepairShopDTO> findAllByNameStartsWith(String startName);

    List<AutoRepairShopDTO> findAllByNameStartsWithDesc(String startName);

    List<AutoRepairShopDTO> getAutoRepairShopsSortedBy(String sortedBy, Sort.Direction direction);

    List<AutoRepairShopDTO> getAutoRepairShopsByNameAndFoundationDate(String name, LocalDate foundationDate);


}
