package com.project.motorVehicleRepairShop.web.view.controllers;


import com.project.motorVehicleRepairShop.dto.CreateOwnerDTO;
import com.project.motorVehicleRepairShop.dto.OwnerDTO;
import com.project.motorVehicleRepairShop.dto.UpdateOwnerDTO;
import com.project.motorVehicleRepairShop.exceptions.OwnerNotFoundException;
import com.project.motorVehicleRepairShop.services.OwnerService;
import com.project.motorVehicleRepairShop.web.view.model.OwnerViewModel;
import com.project.motorVehicleRepairShop.web.view.model.CreateOwnerViewModel;
import com.project.motorVehicleRepairShop.web.view.model.OwnerViewModel;
import com.project.motorVehicleRepairShop.web.view.model.UpdateOwnerViewModel;
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
@RequestMapping("/owners")
public class OwnerController {
    private final OwnerService ownerService;
    private final ModelMapper modelMapper;

    @GetMapping
    public String getOwners(Model model) {
    final List<OwnerViewModel> owners = ownerService.getOwners()
            .stream()
            .map(this::convertToOwnerViewModel)
            .collect(Collectors.toList());
        model.addAttribute("owners", owners);
        return "/owners/owners";

}

    @GetMapping("/create-owner")
    public String showCreateOwnerForm(Model model) {

        model.addAttribute("owner", new CreateOwnerViewModel());
        return "/owners/create-owner";
    }

    @PostMapping("/create")
    public String createOwner(@Valid @ModelAttribute("owner") CreateOwnerViewModel owner,
                                 BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {

            return "/owners/create-owner";
        }
        ownerService.create(modelMapper.map(owner, CreateOwnerDTO.class));

        return "redirect:/owners";
    }

//    @GetMapping
//    public String getOwnersMotorVehicles(Model model) {
//        final List<OwnerViewModel> owners =
//                ownerService.getAllOwnerMotorVehicles().stream()
//                        .map(this::convertToOwnerViewModel)
//                        .collect(Collectors.toList());
//        model.addAttribute("owners", owners);
//        return "/owners/owners-motor-vehicles";
//    }

    @GetMapping("/edit-owner/{id}")
    public String showEditOwnerForm(Model model, @PathVariable Long id) {

        model.addAttribute("owner", modelMapper.map(ownerService.getOwner(id),
                UpdateOwnerViewModel.class));
        return "/owners/edit-owner";
    }

    @PostMapping("/update/{id}")
    public String updateOwner(@PathVariable long id, @Valid @ModelAttribute("owner") UpdateOwnerViewModel owner,
                                 BindingResult bindingResult,Model model) {
        if (bindingResult.hasErrors()) {

            return "/owners/edit-owner";
        }
        ownerService.updateOwner(id, modelMapper.map(owner, UpdateOwnerDTO.class));
        return "redirect:/owners";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable int id) {
        ownerService.deleteOwner(id);
        return "redirect:/owners";
    }





    private OwnerViewModel convertToOwnerViewModel(OwnerDTO owner) {
        return modelMapper.map(owner, OwnerViewModel.class);
    }

    @ExceptionHandler({OwnerNotFoundException.class})
    public String handleException(OwnerNotFoundException exception, Model model) {
        model.addAttribute("message", exception.getMessage());
        return "/errors/auto-repair-shops-errors";
    }


}
