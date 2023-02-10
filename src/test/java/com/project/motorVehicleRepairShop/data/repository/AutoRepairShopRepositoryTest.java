package com.project.motorVehicleRepairShop.data.repository;

import com.project.motorVehicleRepairShop.data.entity.AutoRepairShop;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class AutoRepairShopRepositoryTest {
    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private AutoRepairShopRepository autoRepairShopRepository;


    @Test
    void findAllByNameTest() {
        String name = "Best Auto";
        AutoRepairShop autoRepairShop = new AutoRepairShop();
        autoRepairShop.setName(name);
        autoRepairShop.setFoundationDate(LocalDate.of(2021, 12, 26));
        testEntityManager.persistAndFlush(autoRepairShop);


        assertThat(autoRepairShopRepository.findAllByName(name).size()).isEqualTo(1);
    }

    @Test
    void findAllByEmptyNameTest() {
        String name = "Best Auto";
        AutoRepairShop autoRepairShop = new AutoRepairShop();
        autoRepairShop.setName(name);
        autoRepairShop.setFoundationDate(LocalDate.of(2021, 12, 26));
        name = "";
        assertThat(autoRepairShopRepository.findAllByName(name).size()).isEqualTo(0);
    }

    @Test
    void findAllByNotFoundNameTest() {
        String name = "Best Auto";
        AutoRepairShop autoRepairShop = new AutoRepairShop();
        autoRepairShop.setName(name);
        autoRepairShop.setFoundationDate(LocalDate.of(2021, 12, 26));
        name = "Perfect Auto";
        assertThat(autoRepairShopRepository.findAllByName(name).size()).isEqualTo(0);
    }
}
