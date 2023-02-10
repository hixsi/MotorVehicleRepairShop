package com.project.motorVehicleRepairShop.services.implementations;





import com.project.motorVehicleRepairShop.data.entity.AutoRepairShopService;
import com.project.motorVehicleRepairShop.data.entity.AutoRepairShopTypesOfService;
import com.project.motorVehicleRepairShop.data.entity.Employee;
import com.project.motorVehicleRepairShop.data.repository.AutoRepairShopServicesRepository;
import com.project.motorVehicleRepairShop.dto.AutoRepairShopServicesDTO;
import com.project.motorVehicleRepairShop.dto.AutoRepairShopServicesMotorVehicleDTO;
import com.project.motorVehicleRepairShop.dto.CreateAutoRepairShopServicesDTO;
import com.project.motorVehicleRepairShop.services.AutoRepairShopServicesService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
@Validated
public class AutoRepairShopServicesServiceImpl implements AutoRepairShopServicesService {

    private final AutoRepairShopServicesRepository autoRepairShopServicesRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<AutoRepairShopServicesMotorVehicleDTO> getAllServicesMotorVehicles() {
        return autoRepairShopServicesRepository.findAll().stream()
                .map(this::convertToAutoRepairShopServicesMotorVehicleDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AutoRepairShopService create(CreateAutoRepairShopServicesDTO service) {

        return autoRepairShopServicesRepository.save(modelMapper.map(service, AutoRepairShopService.class));
    }

    @Override
    public List<AutoRepairShopServicesMotorVehicleDTO> getServicesByType(AutoRepairShopTypesOfService type) {
        return autoRepairShopServicesRepository.findAllByAutoRepairShopTypesOfService(type).stream()
                .map(this::convertToAutoRepairShopServicesMotorVehicleDTO)
                .collect(Collectors.toList());
    }

    private AutoRepairShopServicesMotorVehicleDTO convertToAutoRepairShopServicesMotorVehicleDTO(AutoRepairShopService autoRepairShopService) {

        return modelMapper.map(autoRepairShopService, AutoRepairShopServicesMotorVehicleDTO.class);
    }
}
