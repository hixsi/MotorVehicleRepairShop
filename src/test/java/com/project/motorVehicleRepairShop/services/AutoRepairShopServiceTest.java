package com.project.motorVehicleRepairShop.services;

import com.project.motorVehicleRepairShop.data.entity.AutoRepairShop;
import com.project.motorVehicleRepairShop.data.repository.AutoRepairShopRepository;
import com.project.motorVehicleRepairShop.dto.AutoRepairShopDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class AutoRepairShopServiceTest {
    @MockBean
    private AutoRepairShopRepository autoRepairShopRepository;

    @Autowired
    private AutoRepairShopService autoRepairShopService;

    @Test
    void getAutoRepairShopById() {
        long autoRepairShopId = 1;

        AutoRepairShop autoRepairShop = new AutoRepairShop();
        autoRepairShop.setId(autoRepairShopId);

        Mockito.when(autoRepairShopRepository.findById(autoRepairShopId))
                .thenReturn(Optional.of(autoRepairShop));

        AutoRepairShopDTO AutoRepairShopDTO = autoRepairShopService.getAutoRepairShop(autoRepairShopId);

        assertThat(AutoRepairShopDTO.getId()).isEqualTo(autoRepairShop.getId());
    }
}
