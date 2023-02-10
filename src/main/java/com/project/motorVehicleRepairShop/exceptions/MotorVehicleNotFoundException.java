package com.project.motorVehicleRepairShop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MotorVehicleNotFoundException extends RuntimeException{
    public MotorVehicleNotFoundException(String message) {
        super(message);
    }
}
