package com.hcl.federalHolidays.controller;


import com.hcl.federalHolidays.entity.Holiday;
import com.hcl.federalHolidays.service.FederalHolidayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/holidays")
public class FederalHolidayController {
    private final FederalHolidayService service;

    public FederalHolidayController(FederalHolidayService service) {
        this.service = service;
    }

   @GetMapping
    public List<Holiday> getAllHolidays() {
        return service.getAllHolidays();
    }
   @GetMapping("/{id}")
    public ResponseEntity<Holiday> getHolidayById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getHolidayById(id));
    }

    @PostMapping
    public ResponseEntity<Holiday> addHoliday(@RequestBody Holiday holiday) {
        return ResponseEntity.ok(service.addHoliday(holiday));
    }

   @PutMapping("/{id}")
    public ResponseEntity<Holiday> updateHoliday(@PathVariable Long id, @RequestBody Holiday updatedHoliday) {
        return ResponseEntity.ok(service.updateHoliday(id, updatedHoliday));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHoliday(@PathVariable Long id) {
        service.deleteHoliday(id);
        return ResponseEntity.noContent().build();
    }
}

