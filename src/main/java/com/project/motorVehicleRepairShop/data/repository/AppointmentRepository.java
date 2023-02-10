package com.project.motorVehicleRepairShop.data.repository;

import com.project.motorVehicleRepairShop.data.entity.Appointment;
import com.project.motorVehicleRepairShop.data.entity.AutoRepairShop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
