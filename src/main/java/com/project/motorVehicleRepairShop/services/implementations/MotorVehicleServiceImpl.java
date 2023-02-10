package com.project.motorVehicleRepairShop.services.implementations;

import com.project.motorVehicleRepairShop.data.entity.MotorVehicle;
import com.project.motorVehicleRepairShop.data.entity.MotorVehicle;
import com.project.motorVehicleRepairShop.data.entity.MotorVehicleLabel;
import com.project.motorVehicleRepairShop.data.repository.MotorVehicleRepository;
import com.project.motorVehicleRepairShop.dto.MotorVehicleDTO;
import com.project.motorVehicleRepairShop.dto.CreateMotorVehicleDTO;
import com.project.motorVehicleRepairShop.dto.MotorVehicleDTO;
import com.project.motorVehicleRepairShop.dto.UpdateMotorVehicleDTO;
import com.project.motorVehicleRepairShop.exceptions.MotorVehicleNotFoundException;
import com.project.motorVehicleRepairShop.services.MotorVehicleService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
@Validated
public class MotorVehicleServiceImpl implements MotorVehicleService {
    private final MotorVehicleRepository motorVehicleRepository;


    private final ModelMapper modelMapper;

    @Override
    public List<MotorVehicleDTO> getMotorVehicles() {
        return motorVehicleRepository.findAll().stream()
                .map(this::convertToMotorVehicleDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MotorVehicleDTO getMotorVehicle(long id) {
        return modelMapper.map(motorVehicleRepository.findById(id).orElseThrow(() -> new MotorVehicleNotFoundException("Invalid MotorVehicle Id: " + id)), MotorVehicleDTO.class);
        }

    @Override
    public MotorVehicle create(CreateMotorVehicleDTO createMotorVehicleDTO) {
        return motorVehicleRepository.save(modelMapper.map(createMotorVehicleDTO, MotorVehicle.class));
    }

    @Override
    public MotorVehicle updateMotorVehicle(long id, UpdateMotorVehicleDTO updateMotorVehicleDTO) {
        MotorVehicle motorVehicle = modelMapper.map(updateMotorVehicleDTO, MotorVehicle.class);
        motorVehicle.setId(id);
        return motorVehicleRepository.save(motorVehicle);
    }

    @Override
    public void deleteMotorVehicle(long id) {
        motorVehicleRepository.deleteById(id);

    }

    @Override
    public List<MotorVehicleDTO> getMotorVehiclesByLabel(MotorVehicleLabel label) {
        return motorVehicleRepository.findAllByMotorVehicleLabel(label).stream()
                .map(this::convertToMotorVehicleDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<MotorVehicleDTO> getMotorVehiclesByProductionDate(LocalDate productionDate) {
        return motorVehicleRepository.findAllByProductionDate(productionDate).stream()
                .map(this::convertToMotorVehicleDTO)
                .collect(Collectors.toList());
    }


//    @Override
//    public List<MotorVehicleDTO> getMotorVehiclesByLabel(String label) {
//        return motorVehicleRepository.findAllByLabel(label).stream()
//                .map(this::convertToMotorVehicleDTO)
//                .collect(Collectors.toList());
//    }

//    @Override
//    public List<MotorVehicleDTO> getMotorVehiclesByLabelAndProductionDate(String label, LocalDate productionDate) {
//        return motorVehicleRepository.findAllByLabelAndProductionDate(label,productionDate).stream()
//                .map(this::convertToMotorVehicleDTO)
//                .collect(Collectors.toList());
//    }



    private MotorVehicleDTO convertToMotorVehicleDTO(MotorVehicle motorVehicle) {
        return modelMapper.map(motorVehicle, MotorVehicleDTO.class);
    }
}
