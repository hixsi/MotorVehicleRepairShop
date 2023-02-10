package com.project.motorVehicleRepairShop.services;

import com.project.motorVehicleRepairShop.data.entity.Owner;
import com.project.motorVehicleRepairShop.data.repository.OwnerRepository;
import com.project.motorVehicleRepairShop.dto.OwnerDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class OwnerServiceTest {

    @MockBean
    private OwnerRepository ownerRepository;

    @Autowired
    private OwnerService ownerService;

    @Test
    void getOwnerById() {
        long ownerId = 1;

        Owner owner = new Owner();
        owner.setId(ownerId);

        Mockito.when(ownerRepository.findById(ownerId))
                .thenReturn(Optional.of(owner));

        OwnerDTO ownerDTO = ownerService.getOwner(ownerId);

        assertThat(ownerDTO.getId()).isEqualTo(owner.getId());
    }
}