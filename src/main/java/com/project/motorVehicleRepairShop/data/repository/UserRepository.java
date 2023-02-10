
package com.project.motorVehicleRepairShop.data.repository;


import com.project.motorVehicleRepairShop.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
