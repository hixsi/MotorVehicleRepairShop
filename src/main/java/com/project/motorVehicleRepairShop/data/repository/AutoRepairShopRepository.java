package com.project.motorVehicleRepairShop.data.repository;

import com.project.motorVehicleRepairShop.data.entity.AutoRepairShop;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AutoRepairShopRepository extends JpaRepository<AutoRepairShop, Long> {


    List<AutoRepairShop> findAllByName(String name);

    List<AutoRepairShop> findAllByNameContainingOrderByName(String substringName);

    List<AutoRepairShop> findAllByNameContainingOrderByNameDesc(String substringName);

    List<AutoRepairShop> findAllByNameStartsWith(String startName, Sort sort);
    List<AutoRepairShop> findAllByNameAndFoundationDate(String name, LocalDate foundationDate);

}
