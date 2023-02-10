package com.project.motorVehicleRepairShop.services;

import com.project.motorVehicleRepairShop.data.entity.MotorVehicle;
import com.project.motorVehicleRepairShop.data.repository.MotorVehicleRepository;
import com.project.motorVehicleRepairShop.dto.MotorVehicleDTO;
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
class MotorVehicleServiceTest {

    @MockBean
    private MotorVehicleRepository motorVehicleRepository;

    @Autowired
    private MotorVehicleService motorVehicleService;

    @Test
    void getMotorVehicleById() {
        long motorVehicleId = 1;

        MotorVehicle motorVehicle = new MotorVehicle();
        motorVehicle.setId(motorVehicleId);

        Mockito.when(motorVehicleRepository.findById(motorVehicleId))
                .thenReturn(Optional.of(motorVehicle));

        MotorVehicleDTO motorVehicleDTO = motorVehicleService.getMotorVehicle(motorVehicleId);

        assertThat(motorVehicleDTO.getId()).isEqualTo(motorVehicle.getId());
    }
}
