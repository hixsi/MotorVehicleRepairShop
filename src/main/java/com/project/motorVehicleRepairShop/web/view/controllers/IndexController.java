package com.project.motorVehicleRepairShop.web.view.controllers;


import com.project.motorVehicleRepairShop.data.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String getIndex(Model model, Authentication authentication) {
        final String welcomeMessage = "Welcome to auto repair shop system";
        model.addAttribute("welcome", welcomeMessage);

//        Authentication authentication2 = SecurityContextHolder.getContext().getAuthentication();
//        model.addAttribute("username", authentication.getName());

        User principal = (User) authentication.getPrincipal();
        model.addAttribute("username", principal.getUsername());

        return "index";
    }

    @GetMapping("login")
    public String login(Model model) {
        final String welcomeMessage = "Welcome to auto repair shop system";
        model.addAttribute("welcome", welcomeMessage);
        return "login";
    }

    @GetMapping("unauthorized")
    public String unauthorized(Model model) {
        final String welcomeMessage = "Welcome to auto repair shop system";
        model.addAttribute("welcome", welcomeMessage);
        return "unauthorized";
    }

}
