package com.project.motorVehicleRepairShop.services.implementations;

import com.project.motorVehicleRepairShop.data.entity.*;
import com.project.motorVehicleRepairShop.data.repository.AutoRepairShopRepository;
import com.project.motorVehicleRepairShop.dto.*;
import com.project.motorVehicleRepairShop.exceptions.AutoRepairShopNotFoundException;
import com.project.motorVehicleRepairShop.services.AutoRepairShopService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.modelmapper.ModelMapper;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Validated
public class AutoRepairShopServiceImpl implements AutoRepairShopService {
    private final AutoRepairShopRepository autoRepairShopRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<AutoRepairShopDTO> getAutoRepairShops() {
        return autoRepairShopRepository.findAll().stream()
                .map(this::convertToAutoRepairShopDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AutoRepairShopDTO getAutoRepairShop(long id) {
        return modelMapper.map(autoRepairShopRepository.findById(id)
                .orElseThrow(() -> new AutoRepairShopNotFoundException("Invalid AutoRepairShop Id: " + id)), AutoRepairShopDTO.class);
    }

    @Override
    public AutoRepairShop create(CreateAutoRepairShopDTO createAutoRepairShopDTO) {
        return autoRepairShopRepository.save(modelMapper.map(createAutoRepairShopDTO, AutoRepairShop.class));
    }

    @Override
    public AutoRepairShop updateAutoRepairShop(long id, UpdateAutoRepairShopDTO updateAutoRepairShopDTO) {
        AutoRepairShop autoRepairShop = modelMapper.map(updateAutoRepairShopDTO, AutoRepairShop.class);
        autoRepairShop.setId(id);
        return autoRepairShopRepository.save(autoRepairShop);
    }

    @Override
    public void deleteAutoRepairShop(long id) {
        System.out.println("!!!!!!!!!!!!!!!!!!!" + id);
        autoRepairShopRepository.deleteById(id);

    }

    @Override
    public List<AutoRepairShopDTO> getAutoRepairShopsByName(String name) {
        return autoRepairShopRepository.findAllByName(name).stream()
                .map(this::convertToAutoRepairShopDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> getAllEmployeesByAutoRepairShopId(long id) {
        AutoRepairShopEmployeesDTO autoRepairShop = modelMapper.map(getAutoRepairShop(id), AutoRepairShopEmployeesDTO.class);
        return autoRepairShop.getEmployees();
    }







    @Override
    public List<AutoRepairShopDTO> getAutoRepairShopsByNameContainingOrderByName(String substringName) {
        return autoRepairShopRepository.findAllByNameContainingOrderByName(substringName).stream()
                .map(this::convertToAutoRepairShopDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AutoRepairShopDTO> getAutoRepairShopsByNameContainingOrderByNameDesc(String substringName) {
        return autoRepairShopRepository.findAllByNameContainingOrderByNameDesc(substringName).stream()
                .map(this::convertToAutoRepairShopDTO)
                .collect(Collectors.toList());
    }



    @Override
    public List<AutoRepairShopDTO> findAllByNameStartsWith(String startName) {
        return autoRepairShopRepository.findAllByNameStartsWith(startName, Sort.by("name")).stream()
                .map(this::convertToAutoRepairShopDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AutoRepairShopDTO> findAllByNameStartsWithDesc(String startName) {
        return autoRepairShopRepository.findAllByNameStartsWith(
                        startName, Sort.by(Sort.Direction.DESC, "name")).stream()
                .map(this::convertToAutoRepairShopDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AutoRepairShopDTO> getAutoRepairShopsSortedBy(String sortedBy, Sort.Direction direction) {
        return autoRepairShopRepository.findAll(Sort.by(direction, sortedBy)).stream()
                .map(this::convertToAutoRepairShopDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AutoRepairShopDTO> getAutoRepairShopsByNameAndFoundationDate(String name, LocalDate foundationDate) {
        return autoRepairShopRepository.findAllByNameAndFoundationDate(name, foundationDate).stream()
                .map(this::convertToAutoRepairShopDTO)
                .collect(Collectors.toList());
    }


    private AutoRepairShopDTO convertToAutoRepairShopDTO(AutoRepairShop AutoRepairShop) {
        return modelMapper.map(AutoRepairShop, AutoRepairShopDTO.class);
    }

}
