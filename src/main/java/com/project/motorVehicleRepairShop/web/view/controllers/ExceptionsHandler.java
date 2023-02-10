package com.project.motorVehicleRepairShop.web.view.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(Exception.class)
    protected String handleException(Exception exception, Model model) {
        model.addAttribute("message", exception.getMessage());
        return "/errors/errors";
    }

//    @ExceptionHandler(Exception.class)
//    protected ResponseEntity<String> handleException(Exception exception, Model model) {
//        model.addAttribute("message", exception.getMessage());
//        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
//    }

}

