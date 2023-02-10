package com.project.motorVehicleRepairShop.web.view.controllers;

import com.project.motorVehicleRepairShop.data.entity.AppointmentStatus;
import com.project.motorVehicleRepairShop.data.entity.Qualification;
import com.project.motorVehicleRepairShop.data.entity.User;
import com.project.motorVehicleRepairShop.dto.CreateAppointmentDTO;
import com.project.motorVehicleRepairShop.dto.AppointmentAutoRepairShopDTO;
import com.project.motorVehicleRepairShop.dto.UpdateAppointmentDTO;
import com.project.motorVehicleRepairShop.services.AutoRepairShopService;
import com.project.motorVehicleRepairShop.services.AppointmentService;
import com.project.motorVehicleRepairShop.web.view.model.CreateAppointmentViewModel;
import com.project.motorVehicleRepairShop.web.view.model.AppointmentAutoRepairShopViewModel;
import com.project.motorVehicleRepairShop.web.view.model.UpdateAutoRepairShopViewModel;
import com.project.motorVehicleRepairShop.web.view.model.UpdateAppointmentViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


    @Controller
    @AllArgsConstructor
    @RequestMapping("/appointments")
    public class AppointmentController {

        private final AppointmentService appointmentService;

        private final AutoRepairShopService autoRepairShopService;

        private final ModelMapper modelMapper;

        @GetMapping("/create-appointment")
        public String showCreateAppointmentForm(Model model) {
            model.addAttribute("autoRepairShops", autoRepairShopService.getAutoRepairShops());
//            User principal = (User) authentication.getPrincipal();
//            model.addAttribute("user", principal);
            model.addAttribute("appointment", new CreateAppointmentViewModel());
            return "/appointments/create-appointment";
        }

        @PostMapping("/create")
        public String createAppointment(@Valid @ModelAttribute("appointment") CreateAppointmentViewModel appointment,
                                     BindingResult bindingResult, Model model) {
            if (bindingResult.hasErrors()) {
                model.addAttribute("autoRepairShops", autoRepairShopService.getAutoRepairShops());

                return "/appointments/create-appointment";
            }
            appointmentService.create(modelMapper.map(appointment, CreateAppointmentDTO.class));
            return "redirect:/appointments";
        }

        @GetMapping
        public String getAppointmentsAutoRepairShops(Model model) {
            final List<AppointmentAutoRepairShopViewModel> appointments =
                    appointmentService.getAllAppointmentAutoRepairShops().stream()
                            .map(this::convertToAppointmentAutoRepairShopViewModel)
                            .collect(Collectors.toList());
            model.addAttribute("appointments", appointments);
            System.out.println("!!!!!!!!!!!!!"+appointments.isEmpty());
            return "/appointments/appointments-auto-repair-shop";
        }


        @GetMapping("/edit-appointment/{id}")
        public String showEditAppointmentForm(Model model, @PathVariable Long id) {
            model.addAttribute("autoRepairShops", autoRepairShopService.getAutoRepairShops());
            model.addAttribute("statuses", AppointmentStatus.values());
            model.addAttribute("appointment", modelMapper.map(appointmentService.getAppointment(id),
                    UpdateAppointmentViewModel.class));
            return "/appointments/edit-appointment";
        }

        @PostMapping("/update/{id}")
        public String updateAppointmentShop(@PathVariable long id, @Valid @ModelAttribute("appointment") UpdateAppointmentViewModel Appointment,
                                         BindingResult bindingResult,Model model) {
            if (bindingResult.hasErrors()) {
                model.addAttribute("autoRepairShops", autoRepairShopService.getAutoRepairShops());
                model.addAttribute("statuses", AppointmentStatus.values());
                return "/appointments/edit-appointment";
            }
            appointmentService.updateAppointment(id, modelMapper.map(Appointment, UpdateAppointmentDTO.class));
            return "redirect:/appointments";
        }

        @GetMapping("/delete/{id}")
        public String processProgramForm(@PathVariable int id) {
            appointmentService.deleteAppointment(id);
            return "redirect:/appointments";
        }


        private AppointmentAutoRepairShopViewModel convertToAppointmentAutoRepairShopViewModel(AppointmentAutoRepairShopDTO appointment) {
            return modelMapper.map(appointment, AppointmentAutoRepairShopViewModel.class);
        }

    }


