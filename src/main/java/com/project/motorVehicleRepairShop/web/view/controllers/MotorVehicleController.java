package com.project.motorVehicleRepairShop.web.view.controllers;



import com.project.motorVehicleRepairShop.data.entity.MotorVehicle;
import com.project.motorVehicleRepairShop.data.entity.MotorVehicleLabel;
import com.project.motorVehicleRepairShop.dto.CreateMotorVehicleDTO;
import com.project.motorVehicleRepairShop.dto.MotorVehicleDTO;
import com.project.motorVehicleRepairShop.dto.UpdateMotorVehicleDTO;
import com.project.motorVehicleRepairShop.exceptions.MotorVehicleNotFoundException;
import com.project.motorVehicleRepairShop.services.MotorVehicleService;
import com.project.motorVehicleRepairShop.services.OwnerService;
import com.project.motorVehicleRepairShop.web.view.model.CreateMotorVehicleViewModel;
import com.project.motorVehicleRepairShop.web.view.model.MotorVehicleViewModel;
import com.project.motorVehicleRepairShop.web.view.model.UpdateAutoRepairShopViewModel;
import com.project.motorVehicleRepairShop.web.view.model.UpdateMotorVehicleViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
@Controller
@AllArgsConstructor
@RequestMapping("/motor-vehicles")

public class MotorVehicleController {
    private final MotorVehicleService motorVehicleService ;
    private final OwnerService ownerService;
    private final ModelMapper modelMapper;



    @GetMapping
    public String getMotorVehicles(Model model) {

        final List<MotorVehicleViewModel> MotorVehicles = motorVehicleService.getMotorVehicles()
                .stream()
                .map(this::convertToMotorVehicleViewModel)
                .collect(Collectors.toList());
        model.addAttribute("motorVehicles", MotorVehicles);

        return "/motor-vehicles/motor-vehicles";

    }



    @GetMapping("/create-motor-vehicle")
    public String showCreateMotorVehicleForm(Model model) {
        model.addAttribute("motorVehicleLabels", MotorVehicleLabel.values());
        model.addAttribute("owners", ownerService.getOwners());
        model.addAttribute("motorVehicle", new CreateMotorVehicleViewModel());

        return "/motor-vehicles/create-motor-vehicle";
    }

    @PostMapping("/create")
    public String createMotorVehicle(@Valid @ModelAttribute("motorVehicle") CreateMotorVehicleViewModel motorVehicle,
                                       BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("motorVehicleLabels", MotorVehicleLabel.values());
            model.addAttribute("owners", ownerService.getOwners());
            return "/motor-vehicles/create-motor-vehicle";
        }
        motorVehicleService.create(modelMapper.map(motorVehicle, CreateMotorVehicleDTO.class));
        return "redirect:/motor-vehicles";
    }

    @GetMapping("/edit-motor-vehicle/{id}")
    public String showEditMotorVehicleForm(Model model, @PathVariable Long id) {
        model.addAttribute("motorVehicleLabels", MotorVehicleLabel.values());
        model.addAttribute("owners", ownerService.getOwners());
        model.addAttribute("motorVehicle", modelMapper.map(motorVehicleService.getMotorVehicle(id),
                UpdateMotorVehicleViewModel.class));
        return "/motor-vehicles/edit-motor-vehicle";
    }

    @PostMapping("/update/{id}")
    public String updateMotorVehicleShop(@PathVariable long id, @Valid @ModelAttribute("motorVehicle") UpdateMotorVehicleViewModel motorVehicle,
                                     BindingResult bindingResult,Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("motorVehicleLabels", MotorVehicleLabel.values());
            model.addAttribute("owners", ownerService.getOwners());
            return "/motor-vehicles/edit-motor-vehicle";
        }
        motorVehicleService.updateMotorVehicle(id, modelMapper.map(motorVehicle, UpdateMotorVehicleDTO.class));
        return "redirect:/motor-vehicles";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable int id) {
        motorVehicleService.deleteMotorVehicle(id);
        return "redirect:/motor-vehicles";
    }


    @GetMapping("/search-motor-vehicle")
    public String processSearchMotorVehicleForm() {
        return "/motor-vehicles/search-motor-vehicle";
    }
    @GetMapping("/search-motor-vehicle-label")
    public String processSearchMotorVehicleLabelForm(Model model) {

        return "/motor-vehicles/search-motor-vehicle-label";
    }

    @GetMapping("/production-date")
    public String getMotorVehiclesByProductionDate(Model model,
                                                    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate productionDate) {
        List<MotorVehicleViewModel> motorVehicles = motorVehicleService
                .getMotorVehiclesByProductionDate(productionDate)
                .stream()
                .map(this::convertToMotorVehicleViewModel)
                .collect(Collectors.toList());
        model.addAttribute("motorVehicles", motorVehicles);
        return "/motor-vehicles/motor-vehicles";
    }


    @GetMapping("/label")
    public String getMotorVehiclesByLabel(Model model,
                                                   @RequestParam MotorVehicleLabel motorVehicleLabel) {
        List<MotorVehicleViewModel> motorVehicles = motorVehicleService
                .getMotorVehiclesByLabel(motorVehicleLabel)
                .stream()
                .map(this::convertToMotorVehicleViewModel)
                .collect(Collectors.toList());

        model.addAttribute("motorVehicles", motorVehicles);
        return "/motor-vehicles/motor-vehicles";
    }

    private MotorVehicleViewModel convertToMotorVehicleViewModel(MotorVehicleDTO MotorVehicleDTO) {
        return modelMapper.map(MotorVehicleDTO, MotorVehicleViewModel.class);
    }

    @ExceptionHandler({MotorVehicleNotFoundException.class})
    public String handleException(MotorVehicleNotFoundException exception, Model model) {
        model.addAttribute("message", exception.getMessage());
        return "/errors/motor-vehicles-errors";
    }
}
