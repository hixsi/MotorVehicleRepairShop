package com.project.motorVehicleRepairShop.web.view.controllers;


import com.project.motorVehicleRepairShop.data.entity.MotorVehicleLabel;
import com.project.motorVehicleRepairShop.data.entity.Qualification;
import com.project.motorVehicleRepairShop.dto.AutoRepairShopDTO;
import com.project.motorVehicleRepairShop.dto.CreateAutoRepairShopDTO;
import com.project.motorVehicleRepairShop.dto.UpdateAutoRepairShopDTO;
import com.project.motorVehicleRepairShop.exceptions.AutoRepairShopNotFoundException;
import com.project.motorVehicleRepairShop.exceptions.EmployeeNotFoundException;
import com.project.motorVehicleRepairShop.services.AutoRepairShopService;
import com.project.motorVehicleRepairShop.web.view.model.AutoRepairShopViewModel;
import com.project.motorVehicleRepairShop.web.view.model.CreateAutoRepairShopViewModel;
import com.project.motorVehicleRepairShop.web.view.model.UpdateAutoRepairShopViewModel;
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
@RequestMapping("/auto-repair-shops")
public class AutoRepairShopController {

    private final AutoRepairShopService autoRepairShopService;
    private final ModelMapper modelMapper;

    @GetMapping
    public String getAutoRepairShops(Model model) {

        final List<AutoRepairShopViewModel> autoRepairShops = autoRepairShopService.getAutoRepairShops()
                .stream()
                .map(this::convertToAutoRepairShopViewModel)
                .collect(Collectors.toList());
        model.addAttribute("autoRepairShops", autoRepairShops);

        return "/auto-repair-shops/auto-repair-shops";

    }

    @GetMapping("/create-auto-repair-shop")
    public String showCreateAutoRepairShopForm(Model model) {
        model.addAttribute("worksWithMotorVehicleLabels", MotorVehicleLabel.values());
        model.addAttribute("autoRepairShop", new CreateAutoRepairShopViewModel());
        return "/auto-repair-shops/create-auto-repair-shop";
    }

    @PostMapping("/create")
    public String createAutoRepairShop(@Valid @ModelAttribute("autoRepairShop") CreateAutoRepairShopViewModel autoRepairShop,
                               BindingResult bindingResult,Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("worksWithMotorVehicleLabels", MotorVehicleLabel.values());
            return "/auto-repair-shops/create-auto-repair-shop";
        }
        autoRepairShopService.create(modelMapper.map(autoRepairShop, CreateAutoRepairShopDTO.class));
        return "redirect:/auto-repair-shops";
    }

    @GetMapping("/edit-auto-repair-shop/{id}")
    public String showEditAutoRepairShopForm(Model model, @PathVariable Long id) {
        model.addAttribute("worksWithMotorVehicleLabels", MotorVehicleLabel.values());
        model.addAttribute("autoRepairShop", modelMapper.map(autoRepairShopService.getAutoRepairShop(id),
                UpdateAutoRepairShopViewModel.class));
        return "/auto-repair-shops/edit-auto-repair-shop";
    }

    @PostMapping("/update/{id}")
    public String updateAutoRepairShop(@PathVariable long id, @Valid @ModelAttribute("autoRepairShop") UpdateAutoRepairShopViewModel autoRepairShop,
                               BindingResult bindingResult,Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("worksWithMotorVehicleLabels", MotorVehicleLabel.values());
            return "/auto-repair-shops/edit-auto-repair-shop";
        }
        autoRepairShopService.updateAutoRepairShop(id, modelMapper.map(autoRepairShop, UpdateAutoRepairShopDTO.class));
        return "redirect:/auto-repair-shops";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable int id) {
        autoRepairShopService.deleteAutoRepairShop(id);
        return "redirect:/auto-repair-shops";
    }


    @GetMapping("/search-auto-repair-shop")
    public String processSearchAutoRepairShopForm() {
        return "/auto-repair-shops/search-auto-repair-shop";
    }


    @GetMapping("/search-auto-repair-shop-foundation-date")
    public String processSearchAutoRepairShopFoundationDateForm() {

        return "/auto-repair-shops/search-autoRepairShops-foundation-date";
    }


    @GetMapping("/names-foundation-date")
    public String getAutoRepairShopsByNameAndFoundationDate(Model model, @RequestParam String AutoRepairShopName,
                                                    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate foundationDate) {
        List<AutoRepairShopViewModel> AutoRepairShops = autoRepairShopService
                .getAutoRepairShopsByNameAndFoundationDate(AutoRepairShopName, foundationDate)
                .stream()
                .map(this::convertToAutoRepairShopViewModel)
                .collect(Collectors.toList());
        model.addAttribute("autoRepairShops", AutoRepairShops);
        return "/auto-repair-shops/auto-repair-shops";
    }

    private AutoRepairShopViewModel convertToAutoRepairShopViewModel(AutoRepairShopDTO AutoRepairShopDTO) {
        return modelMapper.map(AutoRepairShopDTO, AutoRepairShopViewModel.class);
    }

    @ExceptionHandler({AutoRepairShopNotFoundException.class, EmployeeNotFoundException.class})
    public String handleException(AutoRepairShopNotFoundException exception, Model model) {
        model.addAttribute("message", exception.getMessage());
        return "/errors/auto-repair-shops-errors";
    }

}
