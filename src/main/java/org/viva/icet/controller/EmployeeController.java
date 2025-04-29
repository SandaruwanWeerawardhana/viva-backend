package org.viva.icet.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.viva.icet.dto.Employee;
import org.viva.icet.service.EmployeeService;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
@CrossOrigin
@Slf4j
public class EmployeeController {
    private final EmployeeService service;

    @PostMapping("/employees")
    public Boolean addEmployee(@RequestBody @Valid Employee employee) {
        log.info(String.valueOf(employee));
        return service.add(employee);
    }

    @PutMapping("/employees/{id}")
    public void updateEmployee(@RequestBody Employee employee, @PathVariable Long id) {
        service.update(employee,id);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/employees")
    List<Employee> getAll() {
        return service.getAll();
    }
}
