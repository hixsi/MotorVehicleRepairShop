package com.project.motorVehicleRepairShop.web.controllers;

import com.project.motorVehicleRepairShop.services.AutoRepairShopService;
import com.project.motorVehicleRepairShop.web.view.controllers.AutoRepairShopController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AutoRepairShopController.class)
public class AutoRepairShopControllerTest {
    @MockBean
    private AutoRepairShopService autoRepairShopService;

    @MockBean
    private ModelMapper modelMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void searchAutoRepairShops() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/auto-repair-shops/search-auto-repair-shop/"))
                .andExpect(status().isOk())
                .andExpect(view().name("/auto-repair-shops/search-auto-repair-shop"));
    }
}
