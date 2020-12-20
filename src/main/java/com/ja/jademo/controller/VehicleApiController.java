package com.ja.jademo.controller;

import com.ja.jademo.model.Vehicle;
import com.ja.jademo.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@RestController
@RequestMapping("/api")
class VehicleApiController {
    @Autowired

    private final VehicleRepository repository;

    VehicleApiController(VehicleRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/vehicles")
    List<Vehicle> all(@RequestParam(required = false) String name) {
        if(StringUtils.isEmpty(name)){ // 해당 데이터가 없다면 전체데이터 리턴
            return repository.findAll();
        }else{
            return repository.findByname(name);
        }
    }

    @PostMapping("/vehicles")
    Vehicle newVehicle(@RequestBody Vehicle newVehicle) {
        return repository.save(newVehicle);
    }

    // Single item

    @GetMapping("/vehicles/{id}")
    Vehicle one(@PathVariable Long id) {

        return repository.findById(id).orElse(null);
    }

    @PutMapping("/vehicles/{id}")
    Vehicle replaceVehicle(@RequestBody Vehicle newVehicle, @PathVariable Long id) {

        return repository.findById(id)
                .map(vehicle -> {
                    vehicle.setName(newVehicle.getName());
                    vehicle.setDriver(newVehicle.getDriver());
                    return repository.save(vehicle);
                })
                .orElseGet(() -> {
                    newVehicle.setId(id);
                    return repository.save(newVehicle);
                });
    }

    @DeleteMapping("/Vehicles/{id}")
    void deleteVehicle(@PathVariable Long id) {
        repository.deleteById(id);
    }
}