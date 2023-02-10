package com.project.motorVehicleRepairShop.services.implementations;

import com.project.motorVehicleRepairShop.data.entity.Appointment;
import com.project.motorVehicleRepairShop.data.entity.Appointment;
import com.project.motorVehicleRepairShop.data.entity.Appointment;
import com.project.motorVehicleRepairShop.data.repository.AppointmentRepository;
import com.project.motorVehicleRepairShop.data.repository.AppointmentRepository;
import com.project.motorVehicleRepairShop.dto.*;
import com.project.motorVehicleRepairShop.dto.AppointmentDTO;
import com.project.motorVehicleRepairShop.exceptions.AppointmentNotFoundException;
import com.project.motorVehicleRepairShop.exceptions.AppointmentNotFoundException;
import com.project.motorVehicleRepairShop.services.AppointmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
@Validated
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final ModelMapper modelMapper;

//    @Override
//    public List<AppointmentDTO> getAppointments() {
//        return appointmentRepository.findAll().stream()
//                .map(this::convertToAppointmentDTO)
//                .collect(Collectors.toList());
//
//    }
//
//    @Override
//    public AppointmentDTO getAppointment(long id) {
//        return modelMapper.map(appointmentRepository.findById(id)
//                .orElseThrow(() -> new AppointmentNotFoundException("Invalid Appointment Id: " + id)), AppointmentDTO.class);
//    }

    @Override
    public Appointment create(CreateAppointmentDTO createAppointmentDTO) {
        return appointmentRepository.save(modelMapper.map(createAppointmentDTO, Appointment.class));
    }

    @Override
    public List<AppointmentAutoRepairShopDTO> getAllAppointmentAutoRepairShops() {
        return appointmentRepository.findAll().stream()
                .map(this::convertToAppointmentAutoRepairShopDTO)
                .collect(Collectors.toList());
    }

//    @Override
//    public void deleteAppointment(long id) {
//        appointmentRepository.deleteById(id);
//
//    }
@Override
public Appointment updateAppointment(long id, UpdateAppointmentDTO updateAppointmentDTO) {
    Appointment appointment = modelMapper.map(updateAppointmentDTO, Appointment.class);
    appointment.setId(id);
    return appointmentRepository.save(appointment);
}

    @Override
    public AppointmentAutoRepairShopDTO getAppointment(long id) {
        return modelMapper.map(appointmentRepository.findById(id)
                .orElseThrow(() -> new AppointmentNotFoundException("Invalid Appointment Id: " + id)), AppointmentAutoRepairShopDTO.class);
    }


    @Override
    public void deleteAppointment(long id) {
        appointmentRepository.deleteById(id);
    }


    private AppointmentAutoRepairShopDTO convertToAppointmentAutoRepairShopDTO(Appointment appointment) {

        return modelMapper.map(appointment, AppointmentAutoRepairShopDTO.class);
    }

    private AppointmentDTO convertToAppointmentDTO(Appointment appointment) {
        return modelMapper.map(appointment, AppointmentDTO.class);
    }
}
