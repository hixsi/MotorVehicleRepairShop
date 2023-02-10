package com.project.motorVehicleRepairShop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AutoRepairShopServicesNotFoundException extends RuntimeException {
    public AutoRepairShopServicesNotFoundException(String message) {
        super(message);
    }
}
