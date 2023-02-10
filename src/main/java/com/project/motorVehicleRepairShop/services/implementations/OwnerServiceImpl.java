package com.project.motorVehicleRepairShop.services.implementations;


import com.project.motorVehicleRepairShop.data.entity.Owner;
import com.project.motorVehicleRepairShop.data.repository.OwnerRepository;
import com.project.motorVehicleRepairShop.dto.CreateOwnerDTO;
import com.project.motorVehicleRepairShop.dto.OwnerDTO;
import com.project.motorVehicleRepairShop.dto.UpdateOwnerDTO;
import com.project.motorVehicleRepairShop.exceptions.OwnerNotFoundException;
import com.project.motorVehicleRepairShop.services.OwnerService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OwnerServiceImpl implements OwnerService {
    private OwnerRepository ownerRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<OwnerDTO> getOwners() {
        return ownerRepository.findAll().stream()
                .map(this::convertToOwnerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<OwnerDTO> getAllOwnerMotorVehicles() {
        return ownerRepository.findAll().stream()
                .map(this::convertToOwnerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Owner create(CreateOwnerDTO owner) {
        return ownerRepository.save(modelMapper.map(owner, Owner.class));
    }

    @Override
    public Owner updateOwner(long id, UpdateOwnerDTO updateOwnerDTO) {
        Owner owner = modelMapper.map(updateOwnerDTO, Owner.class);
        owner.setId(id);


        return ownerRepository.save(owner);
    }

    @Override
    public OwnerDTO getOwner(long id) {
        return modelMapper.map(ownerRepository.findById(id)
                .orElseThrow(() -> new OwnerNotFoundException("Invalid Owner Id: " + id)), OwnerDTO.class);
    }

    @Override
    public void deleteOwner(long id) {
     ownerRepository.deleteById(id);
    }

    private OwnerDTO convertToOwnerDTO(Owner owner) {


        return modelMapper.map(owner, OwnerDTO.class);
    }
}
