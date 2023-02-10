//package com.project.motorVehicleRepairShop.web.api;
//
//
//import com.project.motorVehicleRepairShop.data.entity.AutoRepairShop;
//import com.project.motorVehicleRepairShop.data.entity.Employee;
//import com.project.motorVehicleRepairShop.dto.AutoRepairShopDTO;
//import com.project.motorVehicleRepairShop.dto.CreateAutoRepairShopDTO;
//import com.project.motorVehicleRepairShop.dto.UpdateAutoRepairShopDTO;
//import com.project.motorVehicleRepairShop.services.AutoRepairShopService;
//import com.project.motorVehicleRepairShop.web.view.model.AutoRepairShopViewModel;
//import com.project.motorVehicleRepairShop.web.view.model.CreateAutoRepairShopViewModel;
//import com.project.motorVehicleRepairShop.web.view.model.UpdateAutoRepairShopViewModel;
//import lombok.AllArgsConstructor;
//import org.modelmapper.ModelMapper;
//import org.springframework.data.domain.Sort;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import javax.validation.constraints.Min;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("/api/auto-repair-shops")
//@AllArgsConstructor
//@Validated
//public class AutoRepairShopApiController {
//
//    private final AutoRepairShopService autoRepairShopService;
//
//    private final ModelMapper modelMapper;
//
//    @GetMapping
//    public List<AutoRepairShopDTO> getAutoRepairShops() {
//        return autoRepairShopService.getAutoRepairShops();
//    }
//
//    @RequestMapping("/{id}")
//    public AutoRepairShopDTO getAutoRepairShop(@PathVariable("id") @Min(1) int id) {
//        return autoRepairShopService.getAutoRepairShop(id);
//    }
//
//    @PostMapping
//    public AutoRepairShop createAutoRepairShop(@RequestBody @Valid CreateAutoRepairShopViewModel autoRepairShop) {
//        return autoRepairShopService.create(modelMapper.map(autoRepairShop, CreateAutoRepairShopDTO.class));
//    }
//
//    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
//    public AutoRepairShop updateAutoRepairShop(@PathVariable("id") long id, @RequestBody UpdateAutoRepairShopViewModel autoRepairShop) {
//        return autoRepairShopService.updateAutoRepairShop(id, modelMapper.map(autoRepairShop, UpdateAutoRepairShopDTO.class));
//    }
//
//    @DeleteMapping(value = "/{id}")
//    public void deleteAutoRepairShop(@PathVariable long id) {
//        autoRepairShopService.deleteAutoRepairShop(id);
//    }
//
//
//
//    @RequestMapping("/{id}/employees")
//    public List<Employee> getAutoRepairShopEmployees(@PathVariable long id) {
//        return autoRepairShopService.getAllEmployeesByAutoRepairShopId(id);
//    }
//
//    // Sorting using Order By Asc
//    @RequestMapping("/name-containing/{substringName}")
//    public List<AutoRepairShopViewModel> getAutoRepairShopsByNameContainingOrderByName(@PathVariable String substringName) {
//        return autoRepairShopService.getAutoRepairShopsByNameContainingOrderByName(substringName)
//                .stream()
//                .map(this::convertToAutoRepairShopViewModel)
//                .collect(Collectors.toList());
//    }
//
//    // Sorting using Order By Desc
//    @RequestMapping("/name-containing/{substringName}/desc")
//    public List<AutoRepairShopViewModel> getAutoRepairShopsByNameContainingOrderByNameDesc(@PathVariable String substringName) {
//        return autoRepairShopService.getAutoRepairShopsByNameContainingOrderByNameDesc(substringName)
//                .stream()
//                .map(this::convertToAutoRepairShopViewModel)
//                .collect(Collectors.toList());
//    }
//
//    // Sorting using Sort object
//    @RequestMapping("/name-start/{startName}")
//    public List<AutoRepairShopViewModel> getAutoRepairShopsByStartName(@PathVariable String startName) {
//        return autoRepairShopService.findAllByNameStartsWith(startName)
//                .stream()
//                .map(this::convertToAutoRepairShopViewModel)
//                .collect(Collectors.toList());
//    }
//
//    // Sorting using Sort object
//    @RequestMapping("/name-start/{startName}/desc")
//    public List<AutoRepairShopViewModel> getAutoRepairShopsByStartNameDesc(@PathVariable String startName) {
//
//        return autoRepairShopService.findAllByNameStartsWithDesc(startName)
//                .stream()
//                .map(this::convertToAutoRepairShopViewModel)
//                .collect(Collectors.toList());
//    }
//
//    // Sorting using Sort object
//    @RequestMapping("/sorted-by/{sortedBy}/direction/{direction}")
//    public List<AutoRepairShopViewModel> getAutoRepairShopsSortedBy(@PathVariable String sortedBy, @PathVariable String direction) {
//        return autoRepairShopService.getAutoRepairShopsSortedBy(sortedBy, Sort.Direction.fromString(direction))
//                .stream()
//                .map(this::convertToAutoRepairShopViewModel)
//                .collect(Collectors.toList());
//    }
//
//
//
//     //Soft Deletion
//    @PutMapping("/soft-delete/{id}")
//    public void softDeleteAutoRepairShop(@PathVariable long id) {
//        AutoRepairShop AutoRepairShop = modelMapper.map(autoRepairShopService.getAutoRepairShop(id), AutoRepairShop.class);
//        AutoRepairShop.setDeleted(1);
//        autoRepairShopService.updateAutoRepairShop(id, modelMapper.map(AutoRepairShop, UpdateAutoRepairShopDTO.class));
//    }
//
//    private AutoRepairShopViewModel convertToAutoRepairShopViewModel(AutoRepairShopDTO autoRepairShopDTO) {
//        return modelMapper.map(autoRepairShopDTO, AutoRepairShopViewModel.class);
//    }
//}
