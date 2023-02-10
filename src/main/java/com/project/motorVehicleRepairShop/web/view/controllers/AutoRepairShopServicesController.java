package com.project.motorVehicleRepairShop.web.view.controllers;


import com.project.motorVehicleRepairShop.data.entity.*;
import com.project.motorVehicleRepairShop.dto.AutoRepairShopServicesDTO;
import com.project.motorVehicleRepairShop.dto.AutoRepairShopServicesMotorVehicleDTO;
import com.project.motorVehicleRepairShop.dto.CreateAutoRepairShopServicesDTO;

import com.project.motorVehicleRepairShop.services.AutoRepairShopService;
import com.project.motorVehicleRepairShop.services.AutoRepairShopServicesService;
import com.project.motorVehicleRepairShop.services.MotorVehicleService;
import com.project.motorVehicleRepairShop.web.view.model.AutoRepairShopServicesMotorVehicleViewModel;
import com.project.motorVehicleRepairShop.web.view.model.AutoRepairShopServicesViewModel;
import com.project.motorVehicleRepairShop.web.view.model.CreateAutoRepairShopServicesViewModel;

import com.project.motorVehicleRepairShop.web.view.model.MotorVehicleViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
@Controller
@AllArgsConstructor
@RequestMapping("/services")
public class AutoRepairShopServicesController {
    private final AutoRepairShopServicesService autoRepairShopServicesService;

    private final AutoRepairShopService autoRepairShopService;
    private final MotorVehicleService motorVehicleService;

    private final ModelMapper modelMapper;

    @GetMapping("/create-service")
    public String showCreateAutoRepairShopServicesForm(Model model) {

        model.addAttribute("autoRepairShops", autoRepairShopService.getAutoRepairShops());
        model.addAttribute("motorVehicles", motorVehicleService.getMotorVehicles());
        model.addAttribute("autoRepairShopTypesOfServices", AutoRepairShopTypesOfService.values());
        model.addAttribute("service", new CreateAutoRepairShopServicesViewModel());
        return "/services/create-service";
    }

    @PostMapping("/create")
    public String createAutoRepairShopServices(@Valid @ModelAttribute("service") CreateAutoRepairShopServicesViewModel autoRepairShopServices,
                                 BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {


            model.addAttribute("autoRepairShops", autoRepairShopService.getAutoRepairShops());
            model.addAttribute("motorVehicles", motorVehicleService.getMotorVehicles());
            model.addAttribute("autoRepairShopTypesOfServices", AutoRepairShopTypesOfService.values());
            return "/services/create-service";
        }

        if(autoRepairShopServices.getAutoRepairShop().getWorksWithMotorVehicleLabel()==MotorVehicleLabel.ALL ||
                autoRepairShopServices.getAutoRepairShop().getWorksWithMotorVehicleLabel()==autoRepairShopServices.getMotorVehicle().getMotorVehicleLabel()) {
            for(Employee employee:autoRepairShopServices.getAutoRepairShop().getEmployees()) {
                if (employee.getQualification() == Qualification.AUTO_MECHANIC && autoRepairShopServices.getAutoRepairShopTypesOfService() == AutoRepairShopTypesOfService.ENGINE_SERVICE||
                employee.getQualification() == Qualification.DETAILING_SPECIALIST && autoRepairShopServices.getAutoRepairShopTypesOfService() == AutoRepairShopTypesOfService.PAINTING||
                employee.getQualification() == Qualification.PARTS_DISTRIBUTOR && autoRepairShopServices.getAutoRepairShopTypesOfService() == AutoRepairShopTypesOfService.CHANGING_PARTS||
                employee.getQualification() == Qualification.AUTO_MECHANIC && autoRepairShopServices.getAutoRepairShopTypesOfService() == AutoRepairShopTypesOfService.BREAKS_SERVICE) {
                }

                autoRepairShopServicesService.create(modelMapper.map(autoRepairShopServices, CreateAutoRepairShopServicesDTO.class));
                break;
            }
        }

        return "redirect:/services";
    }

    @GetMapping
    public String getAutoRepairShopServicesMotorVehicles(Model model) {
        final List<AutoRepairShopServicesMotorVehicleViewModel> autoRepairShopServices =
                autoRepairShopServicesService.getAllServicesMotorVehicles().stream()
                        .map(this::convertToAutoRepairShopServicesMotorVehicleViewModel)
                        .collect(Collectors.toList());
        model.addAttribute("services", autoRepairShopServices);
        return "/services/services-motor-vehicles";
    }
    @GetMapping("/search-by-service-type")
    public String processSearchServiceByTypeForm(Model model) {

        return "/services/search-by-service-type";
    }

    @GetMapping("/service-type")
    public String getServicesByType(Model model,
                                          @RequestParam AutoRepairShopTypesOfService type) {
        List<AutoRepairShopServicesMotorVehicleViewModel> services = autoRepairShopServicesService
                .getServicesByType(type)
                .stream()
                .map(this::convertToAutoRepairShopServicesMotorVehicleViewModel)
                .collect(Collectors.toList());

        model.addAttribute("services", services);
        return "/services/services";
    }

    private AutoRepairShopServicesViewModel  convertToAutoRepairShopServicesViewModel(AutoRepairShopServicesDTO autoRepairShopServicesDTO) {
        return modelMapper.map(autoRepairShopService, AutoRepairShopServicesViewModel.class);
    }


    private AutoRepairShopServicesMotorVehicleViewModel convertToAutoRepairShopServicesMotorVehicleViewModel(AutoRepairShopServicesMotorVehicleDTO autoRepairShopServices) {

        return modelMapper.map(autoRepairShopServices, AutoRepairShopServicesMotorVehicleViewModel.class);
    }
}
