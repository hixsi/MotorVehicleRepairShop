package com.project.motorVehicleRepairShop.services;

import com.project.motorVehicleRepairShop.data.entity.Appointment;
import com.project.motorVehicleRepairShop.data.entity.Appointment;
import com.project.motorVehicleRepairShop.dto.*;


import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

public interface AppointmentService {
//    List<AppointmentDTO> getAppointments();
//
//    AppointmentDTO getAppointment(@Min(1) long id);

    Appointment create(@Valid CreateAppointmentDTO createAppointmentDTO);

    List<AppointmentAutoRepairShopDTO> getAllAppointmentAutoRepairShops();
    Appointment updateAppointment(long id, UpdateAppointmentDTO updateAppointmentDTO);
    AppointmentAutoRepairShopDTO getAppointment(@Min(1) long id);

    void deleteAppointment(long id);

//    void deleteAppointment(long id);

}
