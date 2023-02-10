package com.project.motorVehicleRepairShop.web.view.controllers;


import com.project.motorVehicleRepairShop.data.entity.Qualification;
import com.project.motorVehicleRepairShop.dto.CreateEmployeeDTO;
import com.project.motorVehicleRepairShop.dto.EmployeeAutoRepairShopDTO;
import com.project.motorVehicleRepairShop.dto.UpdateAutoRepairShopDTO;
import com.project.motorVehicleRepairShop.dto.UpdateEmployeeDTO;
import com.project.motorVehicleRepairShop.exceptions.AutoRepairShopNotFoundException;
import com.project.motorVehicleRepairShop.exceptions.EmployeeNotFoundException;
import com.project.motorVehicleRepairShop.services.AutoRepairShopService;
import com.project.motorVehicleRepairShop.services.EmployeeService;
import com.project.motorVehicleRepairShop.web.view.model.CreateEmployeeViewModel;
import com.project.motorVehicleRepairShop.web.view.model.EmployeeAutoRepairShopViewModel;
import com.project.motorVehicleRepairShop.web.view.model.UpdateAutoRepairShopViewModel;
import com.project.motorVehicleRepairShop.web.view.model.UpdateEmployeeViewModel;
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
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    private final AutoRepairShopService autoRepairShopService;

    private final ModelMapper modelMapper;

    @GetMapping("/create-employee")
    public String showCreateEmployeeForm(Model model) {
        model.addAttribute("qualifications", Qualification.values());
        model.addAttribute("autoRepairShops", autoRepairShopService.getAutoRepairShops());
        model.addAttribute("employee", new CreateEmployeeViewModel());
        return "/employees/create-employee";
    }

    @PostMapping("/create")
    public String createEmployee(@Valid @ModelAttribute("employee") CreateEmployeeViewModel employee,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("qualifications", Qualification.values());
            model.addAttribute("autoRepairShops", autoRepairShopService.getAutoRepairShops());
            return "/employees/create-employee";
        }
        employeeService.create(modelMapper.map(employee, CreateEmployeeDTO.class));

        return "redirect:/employees";
    }

    @GetMapping
    public String getEmployeesAutoRepairShops(Model model) {
        final List<EmployeeAutoRepairShopViewModel> employees =
                employeeService.getAllEmployeeAutoRepairShops().stream()
                        .map(this::convertToEmployeeAutoRepairShopViewModel)
                        .collect(Collectors.toList());
        model.addAttribute("employees", employees);
        return "/employees/employees-auto-repair-shops";
    }

    @GetMapping("/edit-employee/{id}")
    public String showEditEmployeeForm(Model model, @PathVariable Long id) {
        model.addAttribute("qualifications", Qualification.values());
        model.addAttribute("autoRepairShops", autoRepairShopService.getAutoRepairShops());
        model.addAttribute("employee", modelMapper.map(employeeService.getEmployee(id),
                UpdateEmployeeViewModel.class));
        return "/employees/edit-employee";
    }

    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable long id, @Valid @ModelAttribute("employee") UpdateEmployeeViewModel employee,
                                       BindingResult bindingResult,Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("qualifications", Qualification.values());
            model.addAttribute("autoRepairShops", autoRepairShopService.getAutoRepairShops());
            return "/employees/edit-employee";
        }
        employeeService.updateEmployee(id, modelMapper.map(employee, UpdateEmployeeDTO.class));
        return "redirect:/employees";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }





    private EmployeeAutoRepairShopViewModel convertToEmployeeAutoRepairShopViewModel(EmployeeAutoRepairShopDTO Employee) {
        return modelMapper.map(Employee, EmployeeAutoRepairShopViewModel.class);
    }

    @ExceptionHandler({EmployeeNotFoundException.class})
    public String handleException(EmployeeNotFoundException exception, Model model) {
        model.addAttribute("message", exception.getMessage());
        return "/errors/auto-repair-shops-errors";
    }




}
